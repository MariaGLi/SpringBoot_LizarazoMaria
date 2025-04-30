package com.adrian.demojpa.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrian.demojpa.domain.Project;
import com.adrian.demojpa.infrastructure.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository _projectRepository) {
        projectRepository = _projectRepository;
    }

    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

}
