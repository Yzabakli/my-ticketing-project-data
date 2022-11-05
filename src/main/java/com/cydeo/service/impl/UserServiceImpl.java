package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.RoleMapper;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final RoleMapper roleMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper mapper, RoleMapper roleMapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        return userRepository.findAll().stream().map(mapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        return mapper.convertToDto(userRepository.findByUserName(username));
    }

    @Override
    public void save(UserDTO user) {

        User save = mapper.convert(user);
        userRepository.save(save);
    }

    @Override
    public void deleteByUserName(String username) {

        userRepository.deleteByUserName(username);
    }

    @Override
    public UserDTO update(UserDTO user) {

        User convert = mapper.convert(user);

        convert.setId(userRepository.findByUserName(user.getUserName()).getId());

        return mapper.convertToDto(userRepository.save(convert));
    }

    @Override
    public void delete(String username) {

        User user = userRepository.findByUserName(username);
        user.setDeleted(true);
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> findByRole_Description(String description) {
        return userRepository.findByRole_DescriptionIgnoreCase(description)
                .stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

}
