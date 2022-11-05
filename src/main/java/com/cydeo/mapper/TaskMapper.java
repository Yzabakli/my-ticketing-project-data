package com.cydeo.mapper;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper extends BaseMapper<Task, TaskDTO> {

    public TaskMapper(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public Task convert(TaskDTO object) {
        return modelMapper.map(object, Task.class);
    }

    @Override
    public TaskDTO convertToDto(Task object) {
        return modelMapper.map(object, TaskDTO.class);
    }
}
