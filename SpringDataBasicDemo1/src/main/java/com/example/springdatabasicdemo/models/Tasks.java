package com.example.springdatabasicdemo.models;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Tasks")
public class Tasks extends BaseEntity
{

    @ManyToOne(cascade =  CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    public Projects project;
    public String name,info,deadline,stat;

    public Tasks() {

    }
    @Column(name = "name", length = 50, nullable = false)
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
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



    public Projects getProject() {
        return project;
    }
    public void setProject(Projects project) {
        this.project = project;
    }


    public Tasks(String name, String info, String deadline, String stat) {

        this.name = name;
        this.info = info;
        this.deadline = deadline;
        this.stat = stat;
    }
}
