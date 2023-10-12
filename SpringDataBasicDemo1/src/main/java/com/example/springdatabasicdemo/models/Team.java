package com.example.springdatabasicdemo.models;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "team")
public class Team extends BaseEntity
{

    //private String name;
    @ManyToOne(cascade =  CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name="project_id")
    private Projects project;

    @OneToMany(mappedBy = "team",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Clerk> clerks;
    public List<Clerk> getClerks() {
        return clerks;
    }
    public Team(String name) {
        this.setName(name);
    }
    public Team() {

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
        return "Team { id" + id + ", name = " + this.getName()  + "}";
    }
}