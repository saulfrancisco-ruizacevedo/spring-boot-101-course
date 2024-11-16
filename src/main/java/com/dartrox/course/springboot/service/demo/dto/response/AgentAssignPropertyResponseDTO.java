package com.dartrox.course.springboot.service.demo.dto.response;

import java.util.List;

public record AgentAssignPropertyResponseDTO(Long id,
                                             String name,
                                             List<PropertyAssignedToAgentResponseDTO> properties) {
}
