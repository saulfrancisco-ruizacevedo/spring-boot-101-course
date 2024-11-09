package com.dartrox.course.springboot.service.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomErrorMessage {

    BAD_REQUEST("The given resource is malformed");

    private final String value;
}
