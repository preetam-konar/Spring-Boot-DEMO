package com.konar.myapp.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("Constructor in: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Nadal";
    }

}
