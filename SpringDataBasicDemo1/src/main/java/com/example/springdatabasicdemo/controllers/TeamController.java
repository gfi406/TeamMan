package com.example.springdatabasicdemo.controllers;
import com.example.springdatabasicdemo.dtos.ClerkDto;
import com.example.springdatabasicdemo.dtos.CountDto;
import com.example.springdatabasicdemo.dtos.TeamDto;
import com.example.springdatabasicdemo.services.TeamService;
import com.example.springdatabasicdemo.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private  TeamService teamService;
    @GetMapping("/teams")
    public List<TeamDto> getAllTeams() {
        return teamService.getAllTeams();
    }
    @GetMapping("/teams/{id}")
    public TeamDto getTeam(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }
    @PostMapping("/teams")
    public TeamDto createTeam(@RequestBody TeamDto teamDto) {
        return teamService.createTeam(teamDto);
    }
    @DeleteMapping("/teams/{id}")
    public void deleteTeam(@PathVariable Long id) {
         teamService.deleteTeam(id);
    }
    @GetMapping("/teams/top/{kpi}_{lim}")
    public List<TeamDto> getTopKpi(@PathVariable int kpi,@PathVariable int lim) {
        return teamService.getTopKpiTeam(kpi,lim);
    }
    @GetMapping("/teams/clerks/id_{id}")
    public  List<ClerkDto> getAllClerkFromTeam(@PathVariable Long id) {
        return  teamService.getAllClerkFromTeam(id);
    }
    @GetMapping("/teams/count")
    public List<CountDto> getTeamClerksCount() {
        return teamService.findCount();
    }
}
