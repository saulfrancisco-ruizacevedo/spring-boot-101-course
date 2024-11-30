package com.dartrox.course.springboot.service.demo.repository;

import com.dartrox.course.springboot.service.demo.entity.AgentEntity;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends MongoRepository<AgentEntity, String> {

    Optional<AgentEntity> findByEmail(String email);

    Optional<AgentEntity> findByEmailAndIsActive(String email, boolean isActive);
}
