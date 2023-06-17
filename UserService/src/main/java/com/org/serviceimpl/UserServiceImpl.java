package com.org.serviceimpl;

import com.org.Exception.ResourceNotFoundException;
import com.org.entity.User;
import com.org.repository.UserRepository;
import com.org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        User u = userRepository.save(user);
        return new ResponseEntity<>(u , HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","User-id",id));
        return new ResponseEntity<>(user , HttpStatus.CREATED);
    }
}
