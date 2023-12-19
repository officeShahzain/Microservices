package com.User.Service.controllers;


import com.User.Service.entities.User;
import com.User.Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {

        return ResponseEntity.status (HttpStatus.CREATED).body(userService.saveUser(user));
    }
    @GetMapping("/get/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable("userId")String userId)
    {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
