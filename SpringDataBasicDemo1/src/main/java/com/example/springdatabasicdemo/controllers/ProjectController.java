package com.example.springdatabasicdemo.controllers;
import com.example.springdatabasicdemo.dtos.ClerkDto;
import com.example.springdatabasicdemo.dtos.ProjectDto;
import com.example.springdatabasicdemo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping("/projects")
    public ProjectDto createProject(@RequestBody ProjectDto projectDto) {
        return projectService.createProject(projectDto);
    }
    @GetMapping("/projects/{id}")
    public ProjectDto getProject(@PathVariable Long id){
        return projectService.getProjectById(id);
    }
    @GetMapping("/projects")
    public List<ProjectDto> getProjects() {
        return projectService.getAllProjects();
    }
    @GetMapping("/{projectName}/clerks")
    public List<ClerkDto> getClerksByProjectName(@PathVariable String projectName) {
        return projectService.findAllClerksByProjectName(projectName);
    }
    @PostMapping("/projects/update/{id}")
    public void updateProject(@RequestBody ProjectDto projectDto,@PathVariable Long id){
         projectService.updateProject(projectDto,id);
    }
    @DeleteMapping("/projects/{id}")
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
    }
    @GetMapping("/best")
    public ProjectDto getBestProject() {
        return projectService.getBest();
    }

}