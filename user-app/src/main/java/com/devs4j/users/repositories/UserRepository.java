package com.devs4j.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.users.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{

}
