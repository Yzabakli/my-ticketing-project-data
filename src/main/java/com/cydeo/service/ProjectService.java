package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface ProjectService {

    ProjectDTO findByProjectCode(String code);

    List<ProjectDTO> listAllProjects();

    void save(ProjectDTO project);

    void delete(String code);

    void complete(String code);

    ProjectDTO update(ProjectDTO project);

    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);
}
