package com.dartrox.course.springboot.service.demo.exception.customExceptions;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends CustomAbstractException {

    public ResourceNotFoundException(String customErrorMessage) {
        super(customErrorMessage);
    }

    public ResourceNotFoundException(String customErrorMessage, String field, String value) {
        super(customErrorMessage, field, value);
    }
}