package com.prasant.ecommerce.services;

import com.prasant.ecommerce.models.Address;
import com.prasant.ecommerce.repositories.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    IAddressRepository addressRepository;

    public String createAddresses(List<Address> addressList) {
        addressRepository.saveAll(addressList);
        return "Addresses are created!";
    }
}
