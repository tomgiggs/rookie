package com.streamcompute.learn.rookie.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDemo {
    @RequestMapping("/")

    String home() {
        return "Hello World!";
    }
}

