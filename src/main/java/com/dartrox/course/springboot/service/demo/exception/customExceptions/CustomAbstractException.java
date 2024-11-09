package com.dartrox.course.springboot.service.demo.exception.customExceptions;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@SuppressWarnings("rawtypes")
public abstract class CustomAbstractException extends RuntimeException {

    private final String customErrorMessage;

    private final HttpStatus status;

    private final String field;

    private final String value;

    private static final Map<HttpStatus, Class> statusMap = new HashMap<>();

    static {
        statusMap.put(NOT_FOUND, ResourceNotFoundException.class);
        statusMap.put(BAD_REQUEST, BadRequestException.class);
    }

    public CustomAbstractException(String customErrorMessage) {
        super(customErrorMessage);
        this.customErrorMessage = customErrorMessage;
        this.field = null;
        this.value = null;
        this.status = getHttpStatus();
    }

    public CustomAbstractException(String customErrorMessage, String field, String value) {
        super(customErrorMessage);
        this.customErrorMessage = customErrorMessage;
        this.field = field;
        this.value = value;
        this.status = getHttpStatus();
    }

    public HttpStatus getHttpStatus() {
        for(Map.Entry<HttpStatus, Class> entry : statusMap.entrySet()) {

            if(entry.getValue().isInstance(this)) {
                return entry.getKey();
            }
        }

        return INTERNAL_SERVER_ERROR;
    }
}
