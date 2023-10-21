

package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.TaskDto;
import com.example.springdatabasicdemo.dtos.TeamDto;
import com.example.springdatabasicdemo.models.Tasks;

import java.util.List;

public interface TaskService
{
    TaskDto createTask(TaskDto task);
    List<TaskDto> getAllTasks();
    TaskDto getTaskById(Long id);

    List<TaskDto> getTasksByProjectName(String projectName);
    void deleteTask(Long id);

    TaskDto updateTask(TaskDto taskDto, Long id);

    List<TaskDto> findLastDoneTasks(String stat,int lim,int month);
}
