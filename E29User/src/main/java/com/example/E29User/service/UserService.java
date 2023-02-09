package com.example.E29User.service;

import com.example.E29User.entity.User;
import com.example.E29User.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> addUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            if (user.getRole().equals("SELLER") || user.getRole().equals("CUSTOMER")) {
                return ResponseEntity.ok(userRepository.save(user));
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<User> deleteUserById(Long id) {

        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok(user.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<User> updateUser(User updateUser) {

        Optional<User> user = userRepository.findById(updateUser.getId());
        if (user.isPresent()) {

            if (userRepository.findByEmail(updateUser.getEmail()).isEmpty() || userRepository.findByEmail(updateUser.getEmail()).get().getId() == updateUser.getId()) {
                if (updateUser.getRole().equals("SELLER") || updateUser.getRole().equals("CUSTOMER")) {
                    return ResponseEntity.ok(userRepository.save(updateUser));
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
