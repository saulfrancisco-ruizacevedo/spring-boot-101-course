package com.dartrox.course.springboot.service.demo.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomErrorMessage {

    public static final String BAD_REQUEST = "The given resource is malformed";
    public static final String BLANK_NAME = "Name must not be blank";
    public static final String BLANK_EMAIL = "Email must not be blank";
    public static final String MIN_AGE = "Agent must be 18+ years";
    public static final String NULL_AGE = "Age must not be null";
}
