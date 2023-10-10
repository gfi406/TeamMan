package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.TaskDto;
import com.example.springdatabasicdemo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TaskController {
    @Autowired
    public TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService)
   {
       this.taskService = taskService;
   }
    @PostMapping("/tasks")
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        return taskService.createTask(taskDto);
    }
    @GetMapping("/tasks/{id}")
    public TaskDto getTask(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    @GetMapping("/tasks")
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }
    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
    @GetMapping("/tasks/project/{projectName}")
    public List<TaskDto> getByProjectName(@PathVariable String projectName) {
        return taskService.getTasksByProjectName(projectName);
    }
    @GetMapping("/tasks/top_{lim}_{month}/{stat}")
    public List<TaskDto> getLastDoneTasks(
            @PathVariable String stat,
            @PathVariable int lim,
            @PathVariable int month
    ){
        return taskService.findLastDoneTasks(stat, lim, month);
    }
}