package com.prasant.ecommerce.controllers;

import com.prasant.ecommerce.models.Users;
import com.prasant.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/")
    public String AddUsers(@RequestBody List<Users> usersList) {
        return userService.createUsers(usersList);
    }

    @GetMapping(value = "/{id}")
    public Users getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
}
