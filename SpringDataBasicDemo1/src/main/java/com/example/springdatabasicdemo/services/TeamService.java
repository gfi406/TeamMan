package com.example.springdatabasicdemo.services;
import com.example.springdatabasicdemo.dtos.*;

import java.util.List;

public interface TeamService
{
    TeamDto createTeam(TeamDto teamDto);

    TeamDto getTeamById(Long id);
    List<TeamDto> getAllTeams();

    List<CountDto> findCount();

    List<ClerkDto> getAllClerkFromTeam(Long teamId);
    void deleteTeam(Long id);
}