package com.cydeo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

public abstract class BaseMapper<K, V> {
     protected final ModelMapper modelMapper;
//    Type tType = new TypeToken<T>() {}.getType();
//    Type rType = new TypeToken<R>() {}.getType();

//    private final Type tType = ((ParameterizedType) getClass()
//            .getGenericSuperclass()).getActualTypeArguments()[0];
//    private final Type rType = ((ParameterizedType) getClass()
//            .getGenericSuperclass()).getActualTypeArguments()[1];

    public BaseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public abstract K convert(V object);

    public abstract V convertToDto(K object);
}
