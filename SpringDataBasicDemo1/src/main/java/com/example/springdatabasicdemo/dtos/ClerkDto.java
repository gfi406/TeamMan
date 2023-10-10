package com.example.springdatabasicdemo.dtos;

public class ClerkDto
{
    public Long id, teamId;
    public int KPI;
    public String title,teamName,name;
    public ClerkDto (Long id, String name, String title, Long teamId, String teamName,int KPI)
    {
        this.id = id;
        this.name = name;
        this.title = title;
        this.teamId = teamId;
        this.teamName = teamName;
        this.KPI = KPI;
    }
    public ClerkDto(){}

    public int _getKPI()
    {
        return KPI;
    }
    public void _setKPI(int KPI)
    {
        this.KPI = KPI;
    }
    public long _getId()
    {
        return id;
    }
    public void _setId(Long id)
    {
        this.id = id;
    }
    public String _getName()
    {
        return name;
    }
    public void _setName(String name)
    {
        this.name = name;
    }
    public String _getTitle()
    {
        return title;
    }
    public void _setTitle(String name)
    {
        this.title = name;
    }
    public Long _getTeam()
    {
        return teamId;
    }
    public void _setTeam(Long teamId)
    {
        this.teamId = teamId;
    }
    public String _getTeamName(){ return teamName;}
    public void _setTeamName(String teamName)
    {
        this.teamName = teamName;
    }


}