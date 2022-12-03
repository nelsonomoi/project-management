package com.oumoi.projectmanagement.service;


import com.oumoi.projectmanagement.entities.Project;
import com.oumoi.projectmanagement.repository.ProjectRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createNewProject(Project project){

        System.out.println("DueDate "+project.getDueDate().toString());
//        LocalDate startDate = LocalDate.parse(project.getStartDate().toString());
//        LocalDate dueDate = LocalDate.parse(project.getDueDate().toString());
//        project.setStartDate(startDate);
//        project.setDueDate(dueDate);

        return projectRepository.save(project);
    }

    public List<Project> getProjectList() {
        return projectRepository.findAll();
    }
}
