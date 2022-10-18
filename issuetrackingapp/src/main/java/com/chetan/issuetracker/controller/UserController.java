package com.chetan.issuetracker.controller;


import com.chetan.issuetracker.dto.UserDTO;
import com.chetan.issuetracker.entity.User;
import com.chetan.issuetracker.repository.UserRepository;
import com.chetan.issuetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {

        User user = userService.add(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        User user = userService.edit(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> getUsers = userService.find();
        return new ResponseEntity<>(getUsers, HttpStatus.OK);
    }

}
