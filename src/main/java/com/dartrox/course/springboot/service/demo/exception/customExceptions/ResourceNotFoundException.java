package com.dartrox.course.springboot.service.demo.exception.customExceptions;

import com.dartrox.course.springboot.service.demo.enums.CustomErrorMessage;
import lombok.Getter;

@Getter
public class ResourceNotFoundException extends CustomAbstractException {

    public ResourceNotFoundException(CustomErrorMessage customErrorMessage) {
        super(customErrorMessage);
    }

    public ResourceNotFoundException(CustomErrorMessage customErrorMessage, String field, String value) {
        super(customErrorMessage, field, value);
    }
}