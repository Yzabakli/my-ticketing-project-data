package com.cydeo.mapper;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper extends BaseMapper<Project, ProjectDTO> {

    public ProjectMapper(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public Project convert(ProjectDTO object) {
        return modelMapper.map(object, Project.class);
    }

    @Override
    public ProjectDTO convertToDto(Project object) {
        return modelMapper.map(object, ProjectDTO.class);
    }
}
