package com.dartrox.course.springboot.service.demo.dto.request;

public record AgentUpdateRequestDTO(String name,
                                    String email,
                                    Boolean isActive) {
}
