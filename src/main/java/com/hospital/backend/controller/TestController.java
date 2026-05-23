package com.hospital.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Hospital Backend Server is Running";
    }

    @GetMapping("/test")
    public String testApi() {
        return "API is working successfully";
    }
}