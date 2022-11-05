package com.cydeo.repository;

import com.cydeo.entity.Project;
import com.cydeo.entity.Task;
import com.cydeo.entity.User;
import com.cydeo.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTaskStatusNot(Status taskStatus);

    List<Task> findByTaskStatus(Status taskStatus);

    long countByProjectAndTaskStatus(Project project, Status taskStatus);

    long countByProjectAndTaskStatusNot(Project project, Status taskStatus);

}