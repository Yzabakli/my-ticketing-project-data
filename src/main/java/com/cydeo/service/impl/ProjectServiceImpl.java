package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Project;
import com.cydeo.enums.Status;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import com.cydeo.repository.TaskRepository;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    private final TaskRepository taskRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.taskRepository = taskRepository;
    }

    @Override
    public ProjectDTO findByProjectCode(String code) {
        return projectMapper.convertToDto(projectRepository.findByProjectCode(code));
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        return projectRepository.findAll().stream().map(projectMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void save(ProjectDTO project) {

        if (project.getProjectStatus() == null) {

            project.setProjectStatus(Status.OPEN);
        }

        projectMapper.convertToDto(projectRepository.save(projectMapper.convert(project)));
    }

    @Override
    public void delete(String code) {

        Project project = projectRepository.findByProjectCode(code);
        project.setDeleted(true);
        projectRepository.save(project);
    }

    @Override
    public void complete(String code) {

        Project project2 = projectRepository.findByProjectCode(code);
        project2.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project2);
    }

    @Override
    public ProjectDTO update(ProjectDTO project) {

        Project convert = projectMapper.convert(project);

        convert.setId(projectRepository.findByProjectCode(project.getProjectCode()).getId());

        convert.setProjectStatus(project.getProjectStatus());

        return projectMapper.convertToDto(projectRepository.save(convert));
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {

        return listAllProjects().stream()
                .filter(projectDTO -> projectDTO.getAssignedManager().equals(manager))
                .peek(projectDTO -> {

                    projectDTO.setCompleteTaskCounts((int) taskRepository.countByProjectAndTaskStatus(projectMapper.convert(projectDTO), Status.COMPLETE));
                    projectDTO.setUnfinishedTaskCounts((int) taskRepository.countByProjectAndTaskStatusNot(projectMapper.convert(projectDTO), Status.COMPLETE));

                })
                .collect(Collectors.toList());
    }
}
