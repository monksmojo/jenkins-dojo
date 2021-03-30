package com.project.SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello-world")
public class HelloWorldController {

    @GetMapping(path = "/sayHi")
    public String sayHelloWorld(){
        return "<h1>Hello World</h1>";
    }

    /*
    testing hello world controller we just want to check
    whether the sayHelloWorld is invoked and it returns
    Hello World string.
     */
}
