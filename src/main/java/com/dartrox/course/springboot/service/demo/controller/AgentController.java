package com.dartrox.course.springboot.service.demo.controller;

import com.dartrox.course.springboot.service.demo.domain.Agent;
import com.dartrox.course.springboot.service.demo.dto.request.AgentCreateRequestDTO;
import com.dartrox.course.springboot.service.demo.dto.response.AgentCreateResponseDTO;
import com.dartrox.course.springboot.service.demo.dto.response.AgentAllResponseDTO;
import com.dartrox.course.springboot.service.demo.mapper.AgentMapper;
import com.dartrox.course.springboot.service.demo.service.AgentService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static com.dartrox.course.springboot.service.demo.constants.UriConstant.AGENT_CREATE;
import static com.dartrox.course.springboot.service.demo.constants.UriConstant.AGENT_GET_ALL;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AgentController {

    private final AgentService agentService;


    @PostMapping(value = AGENT_CREATE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AgentCreateResponseDTO> create(@RequestBody @Valid AgentCreateRequestDTO agentCreateRequestDTO) {
        Agent agent = AgentMapper.INSTANCE.toAgent(agentCreateRequestDTO);

        agent = agentService.create(agent);

        final AgentCreateResponseDTO agentCreateResponseDTO = AgentMapper.INSTANCE.toAgentCreateResponseDTO(agent);
        return ResponseEntity.status(CREATED).body(agentCreateResponseDTO);
    }

    @GetMapping(value = AGENT_GET_ALL, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AgentAllResponseDTO>> getAll() {
        final List<Agent> agentList = agentService.getAll();
        final List<AgentAllResponseDTO> agentListResponseDTO = AgentMapper.INSTANCE.toListAgentAllResponseDTO(agentList);

        return agentListResponseDTO.isEmpty() ?
                ResponseEntity.noContent().build() : ResponseEntity.ok(agentListResponseDTO);
    }
}
