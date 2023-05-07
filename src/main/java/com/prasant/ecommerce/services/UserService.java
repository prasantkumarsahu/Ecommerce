package com.prasant.ecommerce.services;

import com.prasant.ecommerce.models.Users;
import com.prasant.ecommerce.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public String createUsers(List<Users> usersList) {
        userRepository.saveAll(usersList);
        return "Users are created!";
    }

    public Users getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
