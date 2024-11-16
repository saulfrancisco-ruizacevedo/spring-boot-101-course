package com.dartrox.course.springboot.service.demo.repository;

import com.dartrox.course.springboot.service.demo.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
}
