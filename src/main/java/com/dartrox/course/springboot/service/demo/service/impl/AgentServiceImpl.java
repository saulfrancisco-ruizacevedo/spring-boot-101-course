package com.dartrox.course.springboot.service.demo.service.impl;

import com.dartrox.course.springboot.service.demo.domain.Agent;
import com.dartrox.course.springboot.service.demo.domain.Property;
import com.dartrox.course.springboot.service.demo.entity.AgentEntity;
import com.dartrox.course.springboot.service.demo.exception.customExceptions.ResourceNotFoundException;
import com.dartrox.course.springboot.service.demo.mapper.AgentMapper;
import com.dartrox.course.springboot.service.demo.repository.AgentRepository;
import com.dartrox.course.springboot.service.demo.service.AgentService;
import com.dartrox.course.springboot.service.demo.service.PropertyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.dartrox.course.springboot.service.demo.constants.CustomErrorMessage.AGENT_ID_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;

    private final PropertyService propertyService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Agent create(Agent agent) {
        agent.setIsActive(false);

        return save(agent);
    }

    @Override
    public List<Agent> getAll() {
        final List<AgentEntity> agentEntities = agentRepository.findAll();
        return AgentMapper.INSTANCE.toAgentNoPropertiesList(agentEntities);
    }

    @Override
    public Agent assignProperty(Long agentId, Long propertyId) {
        final Agent agent = findById(agentId);
        final Property property = propertyService.findById(propertyId);

        boolean propertyExists = agent.getProperties().stream()
                .anyMatch(prop -> prop.getId().equals(propertyId));

        if (propertyExists) {
            return agent;
        }

        agent.getProperties().add(property);
        return save(agent);
    }

    private Agent findById(Long agentId) {
        AgentEntity agentEntity = agentRepository.findById(agentId)
                .orElseThrow(() -> new ResourceNotFoundException(AGENT_ID_NOT_FOUND));

        return AgentMapper.INSTANCE.toAgent(agentEntity);
    }

    private Agent save(Agent agent) {
        AgentEntity agentEntity = AgentMapper.INSTANCE.toAgentEntity(agent);
        agentEntity = agentRepository.save(agentEntity);

        return AgentMapper.INSTANCE.toAgent(agentEntity);
    }
}
