package com.udemycourse.springboot.learnspringbootjpa.controller;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/hello-word-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello world");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorld(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

}
