package com.prasant.ecommerce.services;

import com.prasant.ecommerce.models.Address;
import com.prasant.ecommerce.models.User;
import com.prasant.ecommerce.repositories.IAddressRepository;
import com.prasant.ecommerce.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    IAddressRepository addressRepository;

    @Autowired
    IUserRepository userRepository;

    public boolean createAddress(Integer id, Address address) {
        boolean response;
        if (userRepository.existsById(id)){
            User user = userRepository.findById(id).orElseThrow();

            // adding user to address ->
            address.setUser(user);

            addressRepository.save(address);

            response = true;
        }
        else {
            response = false;
        }

        return response;
    }
}
