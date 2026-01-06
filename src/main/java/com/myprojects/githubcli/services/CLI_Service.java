package com.myprojects.githubcli.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLI_Service implements CommandLineRunner {

    public void run(String... args) throws Exception {
        System.out.println("CLI_Service started");
        String arg = args[0];
        System.out.println(arg);
    }
}