package com.sensis.chronosservice.controller;

import com.sensis.chronosservice.model.User;
import com.sensis.chronosservice.model.UserDTO;
import com.sensis.chronosservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup")
    public User saveUser(@RequestBody UserDTO user){
        return userService.save(user);
    }

    @GetMapping(path = {"/{id}"})
    public Optional<User> findUser(@PathVariable("id") Long id){

        return userService.findById(id);
    }

    @PutMapping(path = "/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user){

        return userService.update(id, user);
    }

    @DeleteMapping(path = {"/delete/{id}"})
    public void delete(@PathVariable("id") Long id){

        userService.delete(id);

    }

    @GetMapping("/list")
    public List<User> findAll(){

        return userService.findAll();
    }
}
