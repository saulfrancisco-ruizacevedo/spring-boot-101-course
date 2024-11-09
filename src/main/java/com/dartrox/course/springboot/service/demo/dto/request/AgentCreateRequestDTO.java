package com.dartrox.course.springboot.service.demo.dto.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgentCreateRequestDTO(
        @NotBlank(message = "Name must not be blank")
        String name,

        @NotBlank(message = "Email must not be blank")
        String email,

        @Min(value = 18, message = "Agent must be 18+ years")
        @NotNull(message = "Age must not be null")
        Integer age) {
}
