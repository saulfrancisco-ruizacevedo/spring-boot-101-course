package com.dartrox.course.springboot.service.demo.controller


import com.dartrox.course.springboot.service.demo.service.AgentService
import com.dartrox.course.springboot.service.demo.utils.TestUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static com.dartrox.course.springboot.service.demo.utils.TestConstants.AGE
import static com.dartrox.course.springboot.service.demo.utils.TestConstants.EMAIL
import static com.dartrox.course.springboot.service.demo.utils.TestConstants.NAME
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static com.dartrox.course.springboot.service.demo.constants.UriConstant.AGENT_CREATE

@WebAppConfiguration
@SpringBootTest(classes = AgentController)
class AgentControllerSpec extends Specification {

    @SpringBean
    AgentService agentService = Mock(AgentService)

    @Autowired
    AgentController agentController

    MockMvc mockMvc

    ObjectMapper objectMapper = new ObjectMapper()

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(agentController)
                .build()
    }

    def "create - Should call once agentService and return a 201 status code"() {
        given:
        def agentCreateRequestDTO = TestUtils.buildAgentCreateRequestDTO()
        def agent = TestUtils.buildAgent()

        when:
        def result = mockMvc.perform(post(AGENT_CREATE)
                .contentType(APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(agentCreateRequestDTO)))

        then:
        1 * agentService.create({
            it.name == NAME
            it.email == EMAIL
            it.age == AGE
            it.id == null
            it.isActive == null
            it.properties.size() == 0
        }) >> agent
        result.andExpect(status().isCreated())
        noExceptionThrown()
    }
}
