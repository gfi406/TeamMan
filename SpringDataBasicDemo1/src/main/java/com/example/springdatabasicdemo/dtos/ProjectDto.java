package com.example.springdatabasicdemo.dtos;

import jakarta.persistence.Column;

public class ProjectDto
{
    public Long id;
    public String name;
    public String info;
    public String deadline;
    public String stat;
    public ProjectDto(Long id, String name, String info, String deadline, String stat)
    {
        this.id = id;
        this.name = name;
        this.info = info;
        this.deadline = deadline;
        this.stat = stat;
    }
    public ProjectDto(){}
    public void _setId(Long id) {
        this.id = id;
    }
    public Long _getId() {
        return id;
    }

    public String _getName()
    {
        return name;
    }
    private void _setName(String name)
    {
        this.name = name;
    }
    public String _getInfo()
    {
        return info;
    }
    private void _setInfo(String name)
    {
        this.info = name;
    }
    public String _getDeadline()
    {
        return deadline;
    }
    private void _setDeadline(String name)
    {
        this.deadline = name;
    }
    public String _getStat()
    {
        return stat;
    }
    private void _setStat(String name)
    {
        this.stat = name;
    }
}
