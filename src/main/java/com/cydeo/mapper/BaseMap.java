package com.cydeo.mapper;

public interface BaseMap<K, V> {

    K convert(V object);

    V convertToDto(K object);
}
