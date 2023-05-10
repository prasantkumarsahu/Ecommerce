package com.prasant.ecommerce.controllers;

import com.prasant.ecommerce.models.Address;
import com.prasant.ecommerce.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping(value = "/user/{id}")
    public ResponseEntity<String> createAddresses(@PathVariable Integer id, @RequestBody Address address) {
        boolean response = addressService.createAddress(id, address);
        String message = response ? "Address is created" : "Invalid User of userId : " + id;
        HttpStatus status = response ? HttpStatus.CREATED : HttpStatus.NOT_FOUND;
        return new ResponseEntity<String>(message, status);
    }
}
