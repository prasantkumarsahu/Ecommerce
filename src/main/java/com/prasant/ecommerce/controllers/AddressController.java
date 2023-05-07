package com.prasant.ecommerce.controllers;

import com.prasant.ecommerce.models.Address;
import com.prasant.ecommerce.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "addresses")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping(value = "/")
    public String createAddresses(@RequestBody List<Address> addressList) {
        return addressService.createAddresses(addressList);
    }
}
