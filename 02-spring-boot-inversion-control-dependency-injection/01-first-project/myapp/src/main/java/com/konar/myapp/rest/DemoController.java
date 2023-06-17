package com.konar.myapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konar.myapp.common.Coach;

@RestController
public class DemoController {
    
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach thisCoach) {
        myCoach = thisCoach;
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return myCoach.getDailyWorkout();
    }

}
