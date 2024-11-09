package com.dartrox.course.springboot.service.demo.dto.response;

import com.dartrox.course.springboot.service.demo.util.DateTimeUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomErrorResponseDTO {

    private HttpStatus statusCode;

    private String errorMessage;

    @Builder.Default
    private ZonedDateTime errorAt = DateTimeUtils.getCurrentZonedDateTime();

    private String field;

    private String value;

    private String path;
}
