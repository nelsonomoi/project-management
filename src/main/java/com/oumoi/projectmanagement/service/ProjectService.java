package com.oumoi.projectmanagement.service;


import com.oumoi.projectmanagement.entities.Project;
import com.oumoi.projectmanagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createNewProject(Project project){
        return projectRepository.save(project);
    }
}
