package com.dartrox.course.springboot.service.demo.mapper;

import com.dartrox.course.springboot.service.demo.domain.Agent;
import com.dartrox.course.springboot.service.demo.dto.request.AgentCreateRequestDTO;
import com.dartrox.course.springboot.service.demo.dto.response.AgentAllResponseDTO;
import com.dartrox.course.springboot.service.demo.dto.response.AgentAssignPropertyResponseDTO;
import com.dartrox.course.springboot.service.demo.dto.response.AgentCreateResponseDTO;
import com.dartrox.course.springboot.service.demo.entity.AgentEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AgentMapper {

    AgentMapper INSTANCE = Mappers.getMapper(AgentMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "properties", ignore = true)
    Agent toAgent(AgentCreateRequestDTO agentCreateRequestDTO);

    AgentCreateResponseDTO toAgentCreateResponseDTO(Agent agent);

    AgentAllResponseDTO toAgentAllResponseDTO(Agent agent);

    List<AgentAllResponseDTO> toListAgentAllResponseDTO(List<Agent> agentList);

    AgentAssignPropertyResponseDTO toAgentAssignPropertyResponseDTO(Agent agent);

    AgentEntity toAgentEntity(Agent agent);

    Agent toAgent(AgentEntity agentEntity);

    default List<Agent> toAgentList(List<AgentEntity> agentEntities) {
        return agentEntities.stream()
                .map(this::toAgent)
                .collect(Collectors.toList());
    }

    @Mapping(target = "properties", ignore = true)
    Agent toAgentNoProperties(AgentEntity agentEntity);

    default List<Agent> toAgentNoPropertiesList(List<AgentEntity> agentEntities) {
        return agentEntities.stream()
                .map(this::toAgentNoProperties)
                .collect(Collectors.toList());
    }
}
