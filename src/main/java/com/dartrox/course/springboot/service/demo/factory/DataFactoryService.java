package com.dartrox.course.springboot.service.demo.factory;

import com.dartrox.course.springboot.service.demo.entity.AgentEntity;
import com.dartrox.course.springboot.service.demo.entity.PropertyEntity;
import com.dartrox.course.springboot.service.demo.repository.AgentRepository;
import com.dartrox.course.springboot.service.demo.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataFactoryService {

    private final AgentRepository agentRepository;

    private final PropertyRepository propertyRepository;

    public void createAgent(AgentEntity agentEntity) {
        agentRepository.save(agentEntity);
    }

    public void createProperty(PropertyEntity propertyEntity) {
        propertyRepository.save(propertyEntity);
    }
}
