package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.ClerkDto;
import com.example.springdatabasicdemo.services.ClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClerkController {
    @Autowired
    private ClerkService clerkService;
    @GetMapping("/clerks")
    public List<ClerkDto> all() {
        return clerkService.getAll();
    }
    @PostMapping("/clerks")
    public ClerkDto newClerk(@RequestBody ClerkDto newClerk) {
        return clerkService.register(newClerk);
    }
    @GetMapping("/clerks/{id}")
    public ClerkDto one(@PathVariable Long id)  {
        return clerkService.findClerk(id);
    }
    @GetMapping("/teams/clerks/name_{teamName}")
    public List<ClerkDto> getByTeamName(@PathVariable String teamName) {
        return clerkService.findClerksByTeamName(teamName);
    }
    @GetMapping("/clerks/top_kpi_{lim}")
    public List<ClerkDto> findClerkByKPI(@PathVariable int lim){
        return  clerkService.findClerkByKPI(lim);
    }
    @DeleteMapping("/clerks/{id}")
    public void deleteClerk(@PathVariable Long id) {
        clerkService.deleteClerk(id);
    }
    @PostMapping("/clerks/{clerkId}/teams/{teamId}")
    public void transferClerk( @PathVariable Long clerkId, @PathVariable Long teamId ) {
        clerkService.transfer(clerkId, teamId);
    }
}
