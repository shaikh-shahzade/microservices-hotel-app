package com.org.controller;

import com.org.entity.User;
import com.org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers()
    {
        return userService.getAllUsers();
    }
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id)
    {
        return  userService.getUserById(id);
    }
}
