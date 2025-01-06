package com.bootjpa.example.jpaexample.dao;

import com.bootjpa.example.jpaexample.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByName(String name);
    List<User> findByState(String state);
    List<User> findByNameAndCity(String name,String city);
    List<User> findByNameOrCity(String name,String city);
}
