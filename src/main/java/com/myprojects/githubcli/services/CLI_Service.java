package com.myprojects.githubcli.services;

import com.myprojects.githubcli.DTO.GitHubEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CLI_Service implements CommandLineRunner {

    @Autowired
    EventService eventService;

    public void run(String... args) throws Exception {
        System.out.println("Event Activity started");
        String username = args[0];

        List<GitHubEvent> event =  eventService.getEvents(username);
        eventService.print(event);
    }

}