package com.udemycourse.springboot.learnspringbootjpa.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
