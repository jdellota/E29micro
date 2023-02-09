package com.example.E29User.controller;

import com.example.E29User.entity.User;
import com.example.E29User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping(path = "/users")
    public @ResponseBody List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id){
        return userService.deleteUserById(id);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

}
