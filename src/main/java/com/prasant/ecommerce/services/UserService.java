package com.prasant.ecommerce.services;

import com.prasant.ecommerce.models.User;
import com.prasant.ecommerce.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public String createUser(User user) {
        userRepository.save(user);
        return "User is created!";
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }
}
