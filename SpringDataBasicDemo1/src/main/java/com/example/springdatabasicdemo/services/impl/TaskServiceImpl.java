package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.TaskDto;

import com.example.springdatabasicdemo.dtos.TeamDto;
import com.example.springdatabasicdemo.models.Projects;
import com.example.springdatabasicdemo.models.Tasks;
import com.example.springdatabasicdemo.models.Team;
import com.example.springdatabasicdemo.repositories.ProjectRepository;
import com.example.springdatabasicdemo.repositories.TasksRepository;
import com.example.springdatabasicdemo.services.TaskService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TasksRepository taskRepository;
    private final ModelMapper modelMapper;
    private  final ProjectRepository projectRepository;

    @Autowired
    public TaskServiceImpl(TasksRepository taskRepository, ModelMapper modelMapper,ProjectRepository projectRepository)
    {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.projectRepository = projectRepository;

    }
    //ModelMapper modelMapper = new ModelMapper();
    @Override
    public TaskDto createTask(TaskDto newTask)    {
       Tasks task = modelMapper.map(newTask,Tasks.class);
       task = taskRepository.save(task);
       return modelMapper.map(task,TaskDto.class);
    }
    @Override
    public void deleteTask(Long id)    {
        Tasks task = taskRepository.findById(id).orElse(null);
        if(task != null) {
            taskRepository.delete(task);
        }
    }
    @Override
    public  TaskDto updateTask(TaskDto taskDto, Long id){
        Optional<Tasks> taskUP = taskRepository.findById(id);
        if (taskUP.isPresent()) {
            Tasks exteam = taskUP.get();
            Long newPjId = taskDto._getProjectId();
            Optional<Projects> newPj = projectRepository.findById(newPjId);
            if (newPj.isPresent()) {
                Projects updatePj = newPj.get();
                exteam.setProject(updatePj);
                modelMapper.map(taskDto, exteam);
                Tasks updatedTask = taskRepository.save(exteam);
                return modelMapper.map(updatedTask, TaskDto.class);
            }

        }
        return null;
    }
    @Override
    public List<TaskDto> findLastDoneTasks(String stat,int lim,int month){
        List<Tasks> tasks = taskRepository.findLastDoneTasks(month,stat,lim);
        return tasks.stream()
                .map(e -> modelMapper.map(e,TaskDto.class))
                .collect(Collectors.toList());


    }
    @Override
    public List<TaskDto> getAllTasks()    {
        return taskRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e,TaskDto.class))
                .collect(Collectors.toList());
    }

    public List<TaskDto> getTasksByProjectName(String projectName)    {
        List<Tasks> tasks = taskRepository.findAllByProjectName(projectName);
        return tasks.stream()
                .map(e -> modelMapper.map(e,TaskDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public TaskDto getTaskById(Long id)    {
        try {
            Tasks task = taskRepository.findById(id).orElse(null);
            return modelMapper.map(task, TaskDto.class);
        }
        catch (Exception e )
        {
            return  null;
        }
    }
}
