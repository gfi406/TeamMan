package com.example.springdatabasicdemo.dtos;

public class TaskDto
{
    public Long id;
    public String name,info,deadline,stat;
    public Long projectId;

    public TaskDto(Long id, String name, String info, String deadline, String stat, Long projectId)
    {
        this.id =  id;
        this.name = name;
        this.info = info;
        this.deadline = deadline;
        this.stat = stat;
        this.projectId = projectId;
    }
    public TaskDto() {
    }
    public void _setId(Long id)
    {
        this.id = id;
    }
    public Long _getId() {
        return id;
    }
    public void _setName(String name)
    {
        this.name = name;
    }
    public void _setInfo(String info)
    {
        this.info = info;
    }
    public void _setDeadline(String deadline)
    {
        this.deadline = deadline;
    }
    public void _setStat(String stat)
    {
        this.stat = stat;
    }
    public void _setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }
    public String _getName()
     {
        return name;
    }
    public String _getInfo()
    {
        return info;
    }
    public String _getDeadline()
    {
        return deadline;
    }
    public String _getStat()
    {
        return stat;
    }
    public Long _getProjectId()
    {
        return projectId;
    }

}
