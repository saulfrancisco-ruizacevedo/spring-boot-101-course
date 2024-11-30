package com.dartrox.course.springboot.service.demo.service.impl

import com.dartrox.course.springboot.service.demo.repository.AgentRepository
import com.dartrox.course.springboot.service.demo.service.PropertyService
import com.dartrox.course.springboot.service.demo.utils.TestConstants
import com.dartrox.course.springboot.service.demo.utils.TestUtils
import spock.lang.Specification
import spock.lang.Subject

class AgentServiceSpec extends Specification {

    def agentRepository = Mock(AgentRepository)

    def propertyService = Mock(PropertyService)

    @Subject
    def subject = new AgentServiceImpl(agentRepository, propertyService)

    def "create - should call once agentRepository"() {
        given:
        def agent = TestUtils.buildAgent()
        def agentEntity = TestUtils.buildAgentEntity()

        when:
        subject.create(agent)

        then:
        1 * agentRepository.save({
            it.isActive == TestConstants.IS_ACTIVE_FALSE
        }) >> agentEntity
        noExceptionThrown()
    }
}
