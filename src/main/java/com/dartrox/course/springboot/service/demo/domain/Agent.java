package com.dartrox.course.springboot.service.demo.domain;


import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agent {

    private String id;

    private String name;

    private String email;

    private Boolean isActive;

    private Integer age;

    @Builder.Default
    private List<Property> properties = new ArrayList<>(0);
}
