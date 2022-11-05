package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.mapper.RoleMapper;
import com.cydeo.repository.RoleRepository;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

//    private final Mapper mapper;

    private RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper mapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = mapper;
    }

    @Override
    public List<RoleDTO> listAllRoles() {

        return roleRepository.findAll()
                .stream()
                .map(role -> roleMapper.convertToDto(role))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) {

        return roleMapper.convertToDto(roleRepository.findById(id).orElseThrow());
    }
}
