package com.udemycourse.springboot.learnspringbootjpa.user;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * @author bibek
 */
@RestController
@RequestMapping(path = "/jpa")
public class UserJPAResource {

    @Autowired
//    private UserDaoService service;

    private UserRepository repository;

    public UserJPAResource(UserDaoService service, UserRepository repository) {
//        this.service = service;
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    // path variable can be given as {} in path and annotated as PathVariable so its mapped using the variable name
    @RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
    public User retrieveUserById(@PathVariable int id) {
        Optional<User> user = repository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id: "+id);
        return user.get();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = repository.save(user);
        // location gives the full location where we get the id of the user from the saved user object
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        // response entity created returns status as 201
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/users/{id}")
    public void deleteById(@PathVariable int id) {
        repository.deleteById(id);
    }

}
