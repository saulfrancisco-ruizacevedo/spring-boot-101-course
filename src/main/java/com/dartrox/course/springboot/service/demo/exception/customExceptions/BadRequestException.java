package com.dartrox.course.springboot.service.demo.exception.customExceptions;

import lombok.Getter;

@Getter
public class BadRequestException extends CustomAbstractException {


    public BadRequestException(String customErrorMessage) {
        super(customErrorMessage);
    }

    public BadRequestException(String customErrorMessage, String field, String value) {
        super(customErrorMessage, field, value);
    }
}
