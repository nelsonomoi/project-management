package com.oumoi.projectmanagement.controllers;

import com.oumoi.projectmanagement.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping("")
    public String projectListPage(){
        return "projects/project_list";
    }

    @GetMapping("/create")
    public String createProjectPage(Model model){
        model.addAttribute("project",new Project());
        return "projects/new_project";
    }
}
