package com.dartrox.course.springboot.service.demo.service.impl;

import com.dartrox.course.springboot.service.demo.domain.Property;
import com.dartrox.course.springboot.service.demo.entity.PropertyEntity;
import com.dartrox.course.springboot.service.demo.exception.customExceptions.ResourceNotFoundException;
import com.dartrox.course.springboot.service.demo.mapper.PropertyMapper;
import com.dartrox.course.springboot.service.demo.repository.PropertyRepository;
import com.dartrox.course.springboot.service.demo.service.PropertyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.dartrox.course.springboot.service.demo.constants.CustomErrorMessage.PROPERTY_ID_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;


    @Override
    public Property findById(Long id) {
        final PropertyEntity propertyEntity = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(PROPERTY_ID_NOT_FOUND));

        return PropertyMapper.INSTANCE.toProperty(propertyEntity);
    }

    @Override
    public Property save(Property property) {
        PropertyEntity propertyEntity = PropertyMapper.INSTANCE.toPropertyEntity(property);
        propertyEntity = propertyRepository.save(propertyEntity);

        return PropertyMapper.INSTANCE.toProperty(propertyEntity);
    }
}
