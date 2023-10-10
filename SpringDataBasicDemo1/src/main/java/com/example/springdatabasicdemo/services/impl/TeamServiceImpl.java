package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.CountDto;
import com.example.springdatabasicdemo.dtos.TaskDto;
import com.example.springdatabasicdemo.dtos.TeamDto;
import com.example.springdatabasicdemo.models.Projects;
import com.example.springdatabasicdemo.models.Team;
import com.example.springdatabasicdemo.repositories.TeamRepository;
import com.example.springdatabasicdemo.services.TeamService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository ,ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public TeamDto getTeamById(Long id) {
        Team team = teamRepository.findById(id).orElse(null);
        return modelMapper.map(team,TeamDto.class);
    }
    @Override
    public List<TeamDto> getAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, TeamDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<CountDto> findCount(){
        List<CountDto> result = teamRepository.getTeamClerksCountDto();

        for(CountDto row : result) {
            String teamName = row._getName();
            long clerksCount = row._getCount();
        }
        return result;
        }
    @Override
    public TeamDto createTeam(TeamDto teamDto) {
        Team team = modelMapper.map(teamDto,Team.class);
        team = teamRepository.save(team);
        return modelMapper.map(team,TeamDto.class);
    }


}