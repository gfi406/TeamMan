package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;
@Entity
@Table(name = "project")
public class Projects extends BaseEntity
{

    private String info,deadline,stat;
    @OneToMany(mappedBy = "project",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Team> teams;
    @OneToMany(mappedBy = "project",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Tasks> tasks;
    public Projects(String name, String info, String deadline, String stat) {
        this.setName(name);
        this.info = info;
        this.stat = stat;
        this.deadline = deadline;
    }
    public Projects() {}
    public Team getTeam()
    {
        return (Team) teams;
    }
    public void setTeams(List<Team> teams)
    {
        this.teams = teams;
    }
    public  Tasks getTasks()
    {
        return (Tasks) tasks;
    }
    public void setTasks(List<Tasks> tasks)
    {
        this.tasks = tasks;
    }

    @Column(name = "info", length = 150, nullable = false)
    public String getInfo()
    {
        return info;
    }
    public void setInfo(String name)
    {
        this.info = name;
    }
    @Column(name = "deadline", length = 20, nullable = false)
    public String getDeadline()
    {
        return deadline;
    }
    public void setDeadline(String name)
    {
        this.deadline = name;
    }
    @Column(name = "stat", length = 20, nullable = false)
    public String getStat()
    {
        return stat;
    }
    public void setStat(String name)
    {
        this.stat = name;
    }

}


