package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ClerkDto;
import com.example.springdatabasicdemo.dtos.TeamDto;

import java.util.List;
import java.util.Optional;

public interface ClerkService {



    void transfer(Long clerkId, Long teamId);
    ClerkDto findClerk(Long id);
    List<ClerkDto> findClerkByKPI(int lim);
    List<ClerkDto> findClerksByTeamName(String teamName);
    List<ClerkDto> getAll();
    ClerkDto register(ClerkDto newClerk);
    ClerkDto updateClerk (ClerkDto clerkDto, Long id);

    void deleteClerk(Long id);
}