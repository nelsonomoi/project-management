package com.oumoi.projectmanagement.controllers;

import com.oumoi.projectmanagement.entities.Project;
import com.oumoi.projectmanagement.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("")
    public String projectListPage(){
        return "projects/project_list";
    }

    @GetMapping("/create")
    public String createProjectPage(Model model){
        model.addAttribute("project",new Project());
        return "projects/new_project";
    }

    @PostMapping("/create")
    public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model,
                                RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            model.addAttribute("project",project);
            redirectAttributes.addFlashAttribute("error","Failed to create new project");
            return "projects/new_project";
        }
        projectService.createNewProject(project);
        redirectAttributes.addFlashAttribute("success","Successfully created new project.");
        return "redirect:/projects";
    }
}
