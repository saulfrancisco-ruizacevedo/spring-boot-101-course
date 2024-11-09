package com.dartrox.course.springboot.service.demo.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import static com.dartrox.course.springboot.service.demo.constants.CustomErrorMessage.BLANK_NAME;
import static com.dartrox.course.springboot.service.demo.constants.CustomErrorMessage.BLANK_EMAIL;
import static com.dartrox.course.springboot.service.demo.constants.CustomErrorMessage.MIN_AGE;
import static com.dartrox.course.springboot.service.demo.constants.CustomErrorMessage.NULL_AGE;

public record AgentCreateRequestDTO(
        @NotBlank(message = BLANK_NAME)
        String name,

        @NotBlank(message = BLANK_EMAIL)
        String email,

        @Min(value = 18, message = MIN_AGE)
        @NotNull(message = NULL_AGE)
        Integer age) {
}
