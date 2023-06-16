package com.konar.springdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    
    @GetMapping("/")
    public String getHello() {
        return "Hello World!";
    }

}
