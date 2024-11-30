package com.dartrox.course.springboot.service.demo.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class AgentEntity {

    @Id
    private String id;

    private String name;

    private String email;

    private Boolean isActive;

    private Integer age;

    @Builder.Default
    private List<PropertyEntity> properties = new ArrayList<>(0);
}
