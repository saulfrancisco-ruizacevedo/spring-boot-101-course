package com.dartrox.course.springboot.service.demo.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UriConstant {

    public static final String AGENT_CREATE = "/agent/create";
    public static final String AGENT_GET_ALL = "/agent/all";
    public static final String AGENT_ASSIGN_PROPERTY = "/agent/{agentId}/property";

}
