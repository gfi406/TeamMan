package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ClerkDto;
import com.example.springdatabasicdemo.dtos.ProjectDto;
import com.example.springdatabasicdemo.models.Clerk;
import com.example.springdatabasicdemo.models.Team;
import com.example.springdatabasicdemo.repositories.ClerkRepository;
import com.example.springdatabasicdemo.repositories.TeamRepository;
import com.example.springdatabasicdemo.services.ClerkService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClerkServiceImpl implements ClerkService {
    private final ClerkRepository clerkRepository;
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public ClerkServiceImpl(ClerkRepository clerkRepository,ModelMapper modelMapper,TeamRepository teamRepository)
    {
        this.clerkRepository = clerkRepository;
        this.modelMapper = modelMapper;
        this.teamRepository = teamRepository;
    }
    @Override
    public void transfer(Long clerkId, Long teamId)
    {
        Clerk clerk = clerkRepository.findById(clerkId).orElse(null);
        if(clerk != null) {
            Team newTeam = new Team();
            newTeam.setId(teamId);
            clerk.setTeam(newTeam);
            clerkRepository.save(clerk);
        }
    }
    @Override
//    public  ClerkDto updateClerk (ClerkDto clerkDto, Long id){
//        Optional<Clerk> clerkUP = clerkRepository.findById(id);// ищем сотрудника по ид
//        if (clerkUP.isPresent()){  //  если нашли
//
//            Clerk exClerk = clerkUP.get();// то что мы будем изменять
//            Long teamId = exClerk.getTeam().getId();
//            Optional<Team> team = teamRepository.findById(teamId);
//            Team exTeam = team.get();
//            modelMapper.map(clerkDto,exClerk);// изменяем на полученую дто
//            exClerk.setTeam(exTeam);
//            Clerk updateClerk = clerkRepository.save(exClerk);// сохраняем
//            return  modelMapper.map(updateClerk,ClerkDto.class);
//        }
//        return null;
//    }
    public ClerkDto updateClerk(ClerkDto clerkDto, Long id) {
        Optional<Clerk> clerkUP = clerkRepository.findById(id);
        if (clerkUP.isPresent()) {
            Clerk exClerk = clerkUP.get();
            Long newTeamId = clerkDto._getTeam();

            Optional<Team> newTeam = teamRepository.findById(newTeamId);
            if (newTeam.isPresent()) {
                Team updatedTeam = newTeam.get();
                exClerk.setTeam(updatedTeam);

                Clerk updatedClerk = clerkRepository.save(exClerk);
                return modelMapper.map(updatedClerk, ClerkDto.class);
            }
        }

        return null;
    }


    @Override
    public ClerkDto findClerk(Long id)
    {
        Clerk clerk = clerkRepository.findById(id).orElse(null);
            return modelMapper.map(clerk,ClerkDto.class);
    }
    @Override
    public  List<ClerkDto> findClerkByKPI(int lim){
        List<Clerk> clerks = clerkRepository.findClerkByKpiOrderByKpiDesc(lim);
        return clerks.stream()
                .map(e -> modelMapper.map(e, ClerkDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<ClerkDto> findClerksByTeamName(String teamName)
    {
        List<Clerk> clerks = clerkRepository.findAllByTeamName(teamName);
        return clerks.stream()
                .map(e -> modelMapper.map(e, ClerkDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<ClerkDto> getAll()    {
        return clerkRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, ClerkDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public ClerkDto register(ClerkDto newClerk)    {
        Clerk clerk = modelMapper.map(newClerk,Clerk.class);
        clerk = clerkRepository.save(clerk);
        return modelMapper.map(clerk,ClerkDto.class);
    }
    @Override
    public void deleteClerk(Long id)    {
        Clerk clerk = clerkRepository.findById(id).orElse(null);
        if (clerk != null){ clerkRepository.delete(clerk);        }
    }


}
