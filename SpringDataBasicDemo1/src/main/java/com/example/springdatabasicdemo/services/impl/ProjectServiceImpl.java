package com.example.springdatabasicdemo.services.impl;
import com.example.springdatabasicdemo.dtos.ClerkDto;
import com.example.springdatabasicdemo.dtos.ProjectDto;
import com.example.springdatabasicdemo.dtos.TaskDto;
import com.example.springdatabasicdemo.models.Projects;
import com.example.springdatabasicdemo.models.Team;
import com.example.springdatabasicdemo.repositories.ProjectRepository;
import com.example.springdatabasicdemo.repositories.TeamRepository;
import com.example.springdatabasicdemo.services.ProjectService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProjectServiceImpl implements ProjectService {
    private final   ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository,ModelMapper modelMapper  ){
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        // Создаем entity из DTO
        Projects project = modelMapper.map(projectDto,Projects.class);
        project = projectRepository.save(project);
        return modelMapper.map(project,ProjectDto.class);
    }
    @Override
    public ProjectDto getProjectById(Long id) {
        Projects project = projectRepository.findById(id).orElse(null);
        return modelMapper.map(project,ProjectDto.class);
    }
    @Override
    public List<ProjectDto> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, ProjectDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public ProjectDto updateProject(ProjectDto projectDto,Long id) {
        Optional<Projects> projectUP = projectRepository.findById(id);
            if (projectUP.isPresent()){
                Projects existingPJ = projectUP.get();
                modelMapper.map(projectDto,existingPJ);
                Projects updatePJ = projectRepository.save(existingPJ);
                return modelMapper.map(updatePJ,ProjectDto.class);
        }
            return null;
    }
    @Override
    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }


}
