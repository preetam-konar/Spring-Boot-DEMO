package com.konar.myapp.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    public FootballCoach() {
        System.out.println("Constructor in: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Messi";
    }

}
