package com.waveaccess.innerResource.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartWebApplication {

    @RequestMapping("/")
    public String start() {
        return "Greetings from Spring Boot!";
    }
}
