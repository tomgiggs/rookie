package com.streamcompute.learn.rookie.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
//@RequestMapping(value = "/springboot")
public class TestController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    //http://127.0.0.1:8080/getuser?userName=ggg 不加后面的参数会报错
    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    String getuser(@RequestParam(value = "userName") String userName){
        return "Hello " + userName;
    }


    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return "hello this is spring boot";
    }
}