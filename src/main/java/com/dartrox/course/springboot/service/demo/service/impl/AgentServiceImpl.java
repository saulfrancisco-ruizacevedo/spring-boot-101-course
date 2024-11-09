package com.dartrox.course.springboot.service.demo.service.impl;

import com.dartrox.course.springboot.service.demo.domain.Agent;
import com.dartrox.course.springboot.service.demo.exception.customExceptions.BadRequestException;
import com.dartrox.course.springboot.service.demo.service.AgentService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.dartrox.course.springboot.service.demo.constants.CustomErrorMessage.BAD_REQUEST;
import static com.dartrox.course.springboot.service.demo.constants.FieldConstant.EMAIL;

@Slf4j
@Service
public class AgentServiceImpl implements AgentService {


    /**
     * {@inheritDoc}
     */
    @Override
    public Agent create(Agent agent) {
        validateAgentOnCreation(agent);
        log.info("Persisting agent");
        log.info("Agent created :D");

        agent.setId(15643L);
        return agent;
    }


    private void validateAgentOnCreation(Agent agent) {
        log.info("Validating agent");

        throw new BadRequestException(BAD_REQUEST, EMAIL, agent.getEmail()); // For example: We are validating the email and it failed :(
    }

    @Override
    public List<Agent> getAll() {
        return List.of();
    }
}
