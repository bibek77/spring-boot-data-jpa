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

    // path variable can be given as {} in path and annotated as PathVariable so its mapped using the variable name
    @RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
    public User retrieveUserById(@PathVariable int id) {
        User user = service.findOne(id);
        if(user==null)
            throw new UserNotFoundException("id: "+id);
        return user;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);
        // location gives the full location where we get the id of the user from the saved user object
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        // response entity created returns status as 201
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/users/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteOne(id);
    }
}
