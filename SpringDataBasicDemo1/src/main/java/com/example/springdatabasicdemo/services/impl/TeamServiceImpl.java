package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ClerkDto;
import com.example.springdatabasicdemo.dtos.CountDto;
import com.example.springdatabasicdemo.dtos.TaskDto;
import com.example.springdatabasicdemo.dtos.TeamDto;
import com.example.springdatabasicdemo.models.Clerk;
import com.example.springdatabasicdemo.models.Projects;
import com.example.springdatabasicdemo.models.Team;
import com.example.springdatabasicdemo.repositories.ProjectRepository;
import com.example.springdatabasicdemo.repositories.TeamRepository;
import com.example.springdatabasicdemo.services.TeamService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private  final ProjectRepository projectRepository;
    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository ,ModelMapper modelMapper,ProjectRepository projectRepository) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.projectRepository = projectRepository;
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
    public List<ClerkDto> getAllClerkFromTeam(Long teamId){
        List<Clerk> clerks = teamRepository.getAllClerkFromTeam(teamId);
        return  clerks.stream().map(e -> modelMapper.map(e, ClerkDto.class)).collect(Collectors.toList());

    }
    @Override
    public List<TeamDto> getAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, TeamDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<TeamDto> getTopKpiTeam(int kpi,int lim){
        return teamRepository.getTopKpiTeam(kpi,lim)
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
    @Override
    public TeamDto updateTeam(TeamDto teamDto, Long id) {
        Optional<Team> teamUP = teamRepository.findById(id);
        if (teamUP.isPresent()) {
            Team exteam = teamUP.get();
            Long newPjId = teamDto._getProjectId();
            Optional<Projects> newPj = projectRepository.findById(newPjId);
            if (newPj.isPresent()) {
                Projects updatePj = newPj.get();
                exteam.setProject(updatePj);
                modelMapper.map(teamDto, exteam);
                Team updatedTeam = teamRepository.save(exteam);
                return modelMapper.map(updatedTeam, TeamDto.class);
            }

        }
        return null;
    }


}