package com.org.service;

import com.org.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<User> createUser(User user);

    ResponseEntity<User> getUserById(Long id);
}
