package com.example.springdatabasicdemo.models;
import jakarta.persistence.*;

@Entity
@Table(name = "clerk")
public class Clerk extends BaseEntity
{

    //private String name;
    private String title,teamName;
    private int KPI;
    @ManyToOne(cascade =  CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;



    public Clerk(String name, String title,int KPI) {
        this.setName(name);
        this.title = title;
        this.KPI = KPI;
    }

    public Clerk() { }
    @Column(name = "title", length = 50, nullable = false)
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String name)
    {
        this.title = name;
    }
    public Team getTeam()
    {
        return team;
    }
    public void setTeam( Team team)
    {
       this.team = team;
    }
    @Column(name= "kpi",length = 50, nullable = false)
    public int getKPI() {
        return KPI;
    }
    public void setKPI(int KPI) {
        this.KPI = KPI;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
//    public String toString()
//    {
//        return "Clerk { id=" + id + ", name=" + name + "team"+team + " }";
//    }
}


