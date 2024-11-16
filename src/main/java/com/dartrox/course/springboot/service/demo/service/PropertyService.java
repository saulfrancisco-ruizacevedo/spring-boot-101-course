package com.dartrox.course.springboot.service.demo.service;

import com.dartrox.course.springboot.service.demo.domain.Property;

public interface PropertyService {


    Property findById(Long id);

    Property save(Property property);

}
