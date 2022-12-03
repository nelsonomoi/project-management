package com.oumoi.projectmanagement.api;


import com.oumoi.projectmanagement.entities.Project;
import com.oumoi.projectmanagement.service.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectControllerApi {

    private ProjectService projectService;

    public ProjectControllerApi(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping("/list")
    public List<Project> projectList(){
        return projectService.getProjectList();
    }
}
