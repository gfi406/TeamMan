package com.example.springdatabasicdemo.dtos;

public class TeamDto
{
    public Long id;
    public int  projectId;

    public String name ;
    public TeamDto(Long id, String name, int projectId)
    {
        this.id = id;
        this.name = name;
        this.projectId = projectId;
    }
    public TeamDto(){}
    public long _getId() {
        return id;
    }
    public void _setId(Long id) {
        this.id = id;
    }
    public String _getName() {
    return name;
}
    public void _setName(String name) {
        this.name = name;
    }
    public long _getProjectId()
    {
        return projectId;
    }
    public void _setProjectId(int name)
    {
        this.projectId = name;
    }
}
