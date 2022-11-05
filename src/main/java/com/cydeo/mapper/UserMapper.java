package com.cydeo.mapper;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends BaseMapper<User, UserDTO> {


    public UserMapper(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public User convert(UserDTO object) {
        return modelMapper.map(object, User.class);
    }

    @Override
    public UserDTO convertToDto(User object) {
        return modelMapper.map(object, UserDTO.class);
    }
}
