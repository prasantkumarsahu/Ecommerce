package com.prasant.ecommerce.repositories;

import com.prasant.ecommerce.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<Users, Integer> {
}
