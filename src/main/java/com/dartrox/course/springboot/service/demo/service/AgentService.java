package com.dartrox.course.springboot.service.demo.service;

import com.dartrox.course.springboot.service.demo.domain.Agent;
import com.dartrox.course.springboot.service.demo.exception.customExceptions.BadRequestException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AgentService {

    /**
     * Validate and persists an agent.
     *
     * @param agent {@link Agent}
     * @return {@link Agent}
     * @throws BadRequestException if the given agent email is malformed
     */
    Agent create(Agent agent);

    List<Agent> getAll();

    Agent assignProperty(Long agentId, Long propertyId);

    Page<Agent> getAllPageable(Pageable pageable);
}
