package com.dartrox.course.springboot.service.demo.controller;

import com.dartrox.course.springboot.service.demo.domain.Agent;
import com.dartrox.course.springboot.service.demo.domain.Property;
import com.dartrox.course.springboot.service.demo.dto.request.AgentCreateRequestDTO;
import com.dartrox.course.springboot.service.demo.dto.request.PropertyCreateRequestDTO;
import com.dartrox.course.springboot.service.demo.dto.response.AgentAssignPropertyResponseDTO;
import com.dartrox.course.springboot.service.demo.dto.response.AgentCreateResponseDTO;
import com.dartrox.course.springboot.service.demo.dto.response.AgentAllResponseDTO;
import com.dartrox.course.springboot.service.demo.mapper.AgentMapper;
import com.dartrox.course.springboot.service.demo.mapper.PropertyMapper;
import com.dartrox.course.springboot.service.demo.service.AgentService;
import jakarta.validation.Valid;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static com.dartrox.course.springboot.service.demo.constants.UriConstant.AGENT_CREATE;
import static com.dartrox.course.springboot.service.demo.constants.UriConstant.AGENT_GET_ALL;
import static com.dartrox.course.springboot.service.demo.constants.UriConstant.AGENT_ASSIGN_PROPERTY;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AgentController {

    private final AgentService agentService;


    @PostMapping(value = AGENT_CREATE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AgentCreateResponseDTO> create(@RequestBody @Valid AgentCreateRequestDTO agentCreateRequestDTO) {
        Agent agent = AgentMapper.INSTANCE.toAgent(agentCreateRequestDTO);

        agent = agentService.create(agent);

        final AgentCreateResponseDTO agentCreateResponseDTO = AgentMapper.INSTANCE.toAgentCreateResponseDTO(agent);

        log.info("agentCreateResponseDTO: {}", agentCreateResponseDTO);
        return ResponseEntity.status(CREATED).body(agentCreateResponseDTO);
    }

    @GetMapping(value = AGENT_GET_ALL, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AgentAllResponseDTO>> getAll() {
        final List<Agent> agentList = agentService.getAll();
        final List<AgentAllResponseDTO> agentListResponseDTO = AgentMapper.INSTANCE.toListAgentAllResponseDTO(agentList);

        return agentListResponseDTO.isEmpty() ?
                ResponseEntity.noContent().build() : ResponseEntity.ok(agentListResponseDTO);
    }

    @PatchMapping(value = AGENT_ASSIGN_PROPERTY, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AgentAssignPropertyResponseDTO> assignProperty(@PathVariable(value = "agentId") String agentId,
                                                                          @RequestBody PropertyCreateRequestDTO propertyCreateRequestDTO) {
        final Property property = PropertyMapper.INSTANCE.toProperty(propertyCreateRequestDTO);

        final Agent agent = agentService.assignProperty(agentId, property);

        final AgentAssignPropertyResponseDTO agentAssignPropertyResponseDTO = AgentMapper.INSTANCE.toAgentAssignPropertyResponseDTO(agent);
        log.info("Response body: {}", agentAssignPropertyResponseDTO);
        return ResponseEntity.ok(agentAssignPropertyResponseDTO);
    }
}
