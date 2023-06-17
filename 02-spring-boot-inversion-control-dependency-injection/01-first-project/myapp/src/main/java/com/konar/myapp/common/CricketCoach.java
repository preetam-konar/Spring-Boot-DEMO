package com.konar.myapp.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("Constructor in: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice batting and bowling";
    }

}
