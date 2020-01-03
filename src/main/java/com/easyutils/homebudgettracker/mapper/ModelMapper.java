package com.easyutils.homebudgettracker.mapper;

import org.springframework.stereotype.Component;

@Component
public class ModelMapper extends org.modelmapper.ModelMapper {

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        if (source == null) {
            return null;
        }
        return super.map(source, destinationType);
    }
}
