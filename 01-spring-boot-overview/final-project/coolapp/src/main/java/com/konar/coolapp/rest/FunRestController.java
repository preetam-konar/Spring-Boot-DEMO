package com.konar.coolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coach;
    
    @Value("${team.name}")
    private String team;

    @GetMapping("/coach")
    public String getCoach() {
        return coach;
    }

    @GetMapping("/team")
    public String getTeam() {
        return team;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

}
