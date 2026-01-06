package com.myprojects.githubcli.services;

import com.myprojects.githubcli.Configurations.WebConfiguration;
import com.myprojects.githubcli.DTO.GitHubEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class EventService {

    private final WebClient webClient;

    public EventService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<GitHubEvent> getEvents(String username) {
        return webClient.get()
                .uri("/users/{username}/events",username)
                .retrieve()
                .bodyToFlux(GitHubEvent.class)
                .collectList()
                .block();
    }

    public void print(List<GitHubEvent> event) {
        GitHubEvent eve = event.get(0);
        String repo = eve.getRepo().getName();
        System.out.println(repo);
    }
}
