package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.enums.Status;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper mapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    @Override
    public List<TaskDTO> listAllTasks() {
        return taskRepository.findAll().stream().map(mapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void save(TaskDTO task) {

        if (task.getTaskStatus() == null || task.getAssignedDate() == null) {

            task.setTaskStatus(Status.OPEN);
            task.setAssignedDate(LocalDate.now());
        }

        taskRepository.save(mapper.convert(task));
    }

    @Override
    public void deleteById(Long id) {

        Task task = taskRepository.findById(id).orElseThrow();
        task.setDeleted(true);
        taskRepository.save(task);
    }

    @Override
    public TaskDTO findById(Long id) {
        return mapper.convertToDto(taskRepository.findById(id).orElseThrow());
    }

    @Override
    public void update(TaskDTO task) {

        Task convert = mapper.convert(task);

        convert.setId(task.getId());

        convert.setTaskStatus(task.getTaskStatus());

        convert.setAssignedDate(task.getAssignedDate());

        taskRepository.save(convert);
    }

    @Override
    public List<TaskDTO> findAllTasksByStatusIsNot(Status status) {

        return taskRepository.findByTaskStatusNot(status)
                .stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllTasksByStatus(Status status) {

        return taskRepository.findByTaskStatus(status).stream().map(mapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void updateStatus(TaskDTO task) {

        Task convert = mapper.convert(task);

        convert.setId(task.getId());

        convert.setTaskStatus(task.getTaskStatus());

        convert.setAssignedDate(task.getAssignedDate());

        taskRepository.save(convert);
    }
}
