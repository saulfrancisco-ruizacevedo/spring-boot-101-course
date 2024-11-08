package com.dartrox.course.springboot.service.demo.controller;


import com.dartrox.course.springboot.service.demo.domain.Agent;
import com.dartrox.course.springboot.service.demo.dto.request.AgentCreateRequestDTO;
import com.dartrox.course.springboot.service.demo.dto.response.AgentCreateResponseDTO;
import com.dartrox.course.springboot.service.demo.dto.response.AgentAllResponseDTO;
import com.dartrox.course.springboot.service.demo.service.AgentService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/agent")
public class AgentController {

    private final AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }


    @PostMapping("/create")
    public ResponseEntity<AgentCreateResponseDTO> create(@RequestBody AgentCreateRequestDTO agentCreateRequestDTO) {
        Agent agent = new Agent(agentCreateRequestDTO.name(), agentCreateRequestDTO.email());
        agent = agentService.create(agent);

        final AgentCreateResponseDTO agentCreateResponseDTO = new AgentCreateResponseDTO(agent.getId(), agent.getName());

        return ResponseEntity.status(CREATED).body(agentCreateResponseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AgentAllResponseDTO>> getAll() {
        final List<Agent> agentList = agentService.getAll();

        final List<AgentAllResponseDTO> agentListResponseDTO = agentList.stream()
                .map(agent -> new AgentAllResponseDTO(
                        agent.getId(),
                        agent.getName(),
                        agent.isActive()
                ))
                .collect(Collectors.toList());

        return agentListResponseDTO.isEmpty() ?
                ResponseEntity.noContent().build() : ResponseEntity.ok(agentListResponseDTO);
    }
}
