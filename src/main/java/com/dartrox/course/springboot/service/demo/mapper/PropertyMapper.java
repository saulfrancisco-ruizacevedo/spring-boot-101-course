package com.dartrox.course.springboot.service.demo.mapper;

import com.dartrox.course.springboot.service.demo.domain.Property;
import com.dartrox.course.springboot.service.demo.entity.PropertyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PropertyMapper {

    PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class);

    Property toProperty(PropertyEntity propertyEntity);

    PropertyEntity toPropertyEntity(Property property);
}
