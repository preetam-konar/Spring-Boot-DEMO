package com.konar.devtoolsdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    
    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String workout() {
        return "Eat Work Sleep Repeat";
    }

}
