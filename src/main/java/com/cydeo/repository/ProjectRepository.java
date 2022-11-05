package com.cydeo.repository;

import com.cydeo.entity.Project;
import com.cydeo.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByProjectCode(String projectCode);

    long countByAssignedManager_IdAndProjectStatus(Long id, Status projectStatus);
}