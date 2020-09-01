package com.devs4j.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.users.entity.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile,Integer> {

}
