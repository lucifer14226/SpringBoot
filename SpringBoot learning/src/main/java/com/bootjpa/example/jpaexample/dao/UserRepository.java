package com.bootjpa.example.jpaexample.dao;

import com.bootjpa.example.jpaexample.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByName(String name);
    List<User> findByState(String state);
    List<User> findByNameAndCity(String name,String city);
    List<User> findByNameOrCity(String name,String city);

    @Query("select u FROM User u")
    public List<User> getALlUsers();

    @Query("select u From User u WHERE u.name =:n")
    public List<User> getAllUserByName(@Param("n") String name);

    @Query("select u From User u WHERE u.name =:n AND u.city=:c")
    public List<User> getAllUserByNameAndCity(@Param("n") String name,@Param("c") String city);
}
