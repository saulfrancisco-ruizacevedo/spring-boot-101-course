package com.dartrox.course.springboot.service.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    private Long id;

    private String description;

    private String location;
}
