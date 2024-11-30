package com.dartrox.course.springboot.service.demo.utils

import com.dartrox.course.springboot.service.demo.domain.Agent
import com.dartrox.course.springboot.service.demo.dto.request.AgentCreateRequestDTO
import com.dartrox.course.springboot.service.demo.entity.AgentEntity

import static com.dartrox.course.springboot.service.demo.utils.TestConstants.AGE
import static com.dartrox.course.springboot.service.demo.utils.TestConstants.EMAIL
import static com.dartrox.course.springboot.service.demo.utils.TestConstants.ID
import static com.dartrox.course.springboot.service.demo.utils.TestConstants.NAME
import static com.dartrox.course.springboot.service.demo.utils.TestConstants.IS_ACTIVE_FALSE
import static java.util.Collections.emptyList

class TestUtils {

    static AgentCreateRequestDTO buildAgentCreateRequestDTO() {
        return new AgentCreateRequestDTO(NAME, EMAIL, AGE);
    }

    static Agent buildAgent() {
        return Agent.builder()
                .id(ID)
                .name(NAME)
                .email(EMAIL)
                .age(AGE)
                .isActive(IS_ACTIVE_FALSE)
                .properties(emptyList())
                .build()
    }

    static AgentEntity buildAgentEntity() {
        return AgentEntity.builder()
                .id(ID)
                .name(NAME)
                .email(EMAIL)
                .age(AGE)
                .isActive(IS_ACTIVE_FALSE)
                .properties(emptyList())
                .build()
    }

    static List<AgentEntity> buildAgentEntityList() {
        return Arrays.asList(buildAgentEntity())
    }
}
