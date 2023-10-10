package com.example.springdatabasicdemo.models;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "team")
public class Team extends BaseEntity
{

    private String name;
    @ManyToOne
    @JoinColumn(name="project_id")
    private Projects project;

    @OneToMany(mappedBy = "team",cascade = CascadeType.REMOVE)
    private List<Clerk> clerks;
    public List<Clerk> getClerks() {
        return clerks;
    }
    public Team(String s) {
        this.name = s;
    }
    public Team() {

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
    public Projects getProject()
    {
        return project;
    }
    public void setProject(Projects project)
    {
        this.project = project;
    }
    public int getClerksCount() {
        return clerks.size();
    }
    @Override
    public String toString() {
        return "Team { id" + id + ", name = " + name  + "}";
    }
}