package com.dartrox.course.springboot.service.demo.mapper;

import com.dartrox.course.springboot.service.demo.domain.Agent;
import com.dartrox.course.springboot.service.demo.dto.request.AgentCreateRequestDTO;
import com.dartrox.course.springboot.service.demo.dto.response.AgentAllResponseDTO;
import com.dartrox.course.springboot.service.demo.dto.response.AgentCreateResponseDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AgentMapper {

    AgentMapper INSTANCE = Mappers.getMapper(AgentMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    Agent toAgent(AgentCreateRequestDTO agentCreateRequestDTO);

    AgentCreateResponseDTO toAgentCreateResponseDTO(Agent agent);

    AgentAllResponseDTO toAgentAllResponseDTO(Agent agent);

    List<AgentAllResponseDTO> toListAgentAllResponseDTO(List<Agent> agentList);
}
