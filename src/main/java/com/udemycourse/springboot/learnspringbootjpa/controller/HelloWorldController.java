package com.udemycourse.springboot.learnspringbootjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bibek
 */
@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
//    @RequestMapping(method= RequestMethod.GET, path = "/hello")
    public String helloWorld() {
        return "Hello World";
    }
}
