package com.udemycourse.springboot.learnspringbootjpa.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bibek
 */
@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
    public User retrieveUserById(@PathVariable int id) {
        return service.findOne(id);
    }
}
