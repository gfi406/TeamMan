package com.example.springdatabasicdemo.services;
import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.models.Team;

import java.util.List;

public interface TeamService
{
    TeamDto createTeam(TeamDto teamDto);

    TeamDto getTeamById(Long id);
    List<TeamDto> getAllTeams();
    List<TeamDto> getTopKpiTeam(int kpi,int lim);

    List<CountDto> findCount();
    TeamDto updateTeam(TeamDto teamDto, Long id);

    List<ClerkDto> getAllClerkFromTeam(Long teamId);
    void deleteTeam(Long id);
}
