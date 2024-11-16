package com.dartrox.course.springboot.service.demo.repository;

import com.dartrox.course.springboot.service.demo.entity.AgentEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<AgentEntity, Long> {

    Optional<AgentEntity> findByEmail(String email);

    Optional<AgentEntity> findByEmailAndIsActive(String email, boolean isActive);
}
