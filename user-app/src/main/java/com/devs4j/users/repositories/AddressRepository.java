package com.devs4j.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.users.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer>{

}
