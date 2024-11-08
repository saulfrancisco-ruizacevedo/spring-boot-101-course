package com.dartrox.course.springboot.service.demo.service;

import com.dartrox.course.springboot.service.demo.domain.Agent;
import java.util.List;

public interface AgentService {

    Agent create(Agent agent);

    List<Agent> getAll();
}
