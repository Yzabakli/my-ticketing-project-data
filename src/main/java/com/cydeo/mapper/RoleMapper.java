package com.cydeo.mapper;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper extends BaseMapper<Role, RoleDTO> {

    public RoleMapper(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public Role convert(RoleDTO object) {
        return modelMapper.map(object, Role.class);
    }

    @Override
    public RoleDTO convertToDto(Role object) {
        return modelMapper.map(object, RoleDTO.class);
    }
}
