package com.devs4j.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.users.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
