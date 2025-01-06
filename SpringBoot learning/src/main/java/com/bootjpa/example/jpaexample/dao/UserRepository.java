package com.bootjpa.example.jpaexample.dao;

import com.bootjpa.example.jpaexample.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

}
