package com.prasant.ecommerce.controllers;

import com.prasant.ecommerce.models.User;
import com.prasant.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/")
    public ResponseEntity<String> AddUsers(@RequestBody User user) {
        String response = userService.createUser(user);
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Integer id) {
        try{
            User response = userService.getUserById(id);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }
        catch (Exception e){
            System.out.println(e);
            String response = "User is not present!";
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
