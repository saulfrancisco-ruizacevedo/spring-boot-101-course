package com.dartrox.course.springboot.service.demo.dto.response;

import java.util.List;

public record AgentAssignPropertyResponseDTO(String id,
                                             String name,
                                             List<PropertyAssignedToAgentResponseDTO> properties) {
}
