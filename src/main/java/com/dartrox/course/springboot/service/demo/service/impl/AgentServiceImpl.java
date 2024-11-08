package com.dartrox.course.springboot.service.demo.service.impl;

import com.dartrox.course.springboot.service.demo.domain.Agent;
import com.dartrox.course.springboot.service.demo.service.AgentService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService {


    @Override
    public Agent create(Agent agent) {
        System.out.println("Validating agent");
        System.out.println("Persisting agent");
        System.out.println("Agent created :D");

        return agent;
    }

    @Override
    public List<Agent> getAll() {
        return List.of();
    }
}
