package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ClerkDto;
import com.example.springdatabasicdemo.dtos.ProjectDto;

import java.util.List;

public interface ProjectService
{
    ProjectDto createProject(ProjectDto projectDto);
    ProjectDto getProjectById(Long id);
    List<ProjectDto> getAllProjects();
   List<ClerkDto> findAllClerksByProjectName(String name);
    ProjectDto updateProject(ProjectDto projectDto,Long id);
    ProjectDto getBest();
    void deleteProject(Long id);
}
