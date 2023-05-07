package com.prasant.ecommerce.repositories;

import com.prasant.ecommerce.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends CrudRepository<Address, Integer> {
}
