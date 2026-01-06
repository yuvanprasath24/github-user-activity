package com.myprojects.githubcli.services;

import com.myprojects.githubcli.Configurations.WebConfiguration;
import com.myprojects.githubcli.DTO.GitHubEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

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

    public String formatEvent(GitHubEvent event) {

        String repo = event.getRepo().getName();

        return switch (event.getType()){

            case "PushEvent" -> {
                Integer size = event.getPayload().getSize();

                if (size != null) {
                    yield "Pushed " + size + " commits to " + repo;
                } else {
                    yield "Pushed commits to " + repo;
                }
            }

            case "IssuesEvent" ->
                    "Opened a new issue in " + repo;

            case "WatchEvent" ->
                    "Starred " + repo;

            case "ForkEvent" ->
                    "Forked " + repo;

                default ->
                    null;
        };
    }

    public void printEvents(List<GitHubEvent> events) {
        events.stream()
                .map(this::formatEvent)
                .filter(Objects::nonNull)
                .forEach(msg -> System.out.println("-"+msg));
    }
}
