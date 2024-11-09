package com.dartrox.course.springboot.service.demo.exception.customExceptions;

import com.dartrox.course.springboot.service.demo.enums.CustomErrorMessage;
import lombok.Getter;

@Getter
public class BadRequestException extends CustomAbstractException {


    public BadRequestException(CustomErrorMessage customErrorMessage) {
        super(customErrorMessage);
    }

    public BadRequestException(CustomErrorMessage customErrorMessage, String field, String value) {
        super(customErrorMessage, field, value);
    }
}
