package com.dartrox.course.springboot.service.demo.factory;

import com.dartrox.course.springboot.service.demo.entity.AgentEntity;
import com.dartrox.course.springboot.service.demo.entity.PropertyEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DatabaseInitializer implements CommandLineRunner {

    private final DataFactoryService dataFactoryService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Initializing Database with fake data...");

        AgentEntity agent = generateAgent();
        dataFactoryService.createAgent(agent);
        log.info("Agent created: {}", agent.getName());


        createAndPersistProperty("desc", "loc");
        createAndPersistProperty("desc 2", "loc 2");
        log.info("Database initialized with fake data.");
    }

    private void createAndPersistProperty(String description, String location) {
        PropertyEntity property = generateProperty(description, location);
        dataFactoryService.createProperty(property);
        log.info("Property created with description: {}", description);
    }

    protected AgentEntity generateAgent() {
        return AgentEntity.builder()
                .name("TEST")
                .email("test@gmail.com")
                .isActive(true)
                .age(35)
                .build();
    }

    protected PropertyEntity generateProperty(String description, String location) {
        return PropertyEntity.builder()
                .description(description)
                .location(location)
                .build();
    }
}
