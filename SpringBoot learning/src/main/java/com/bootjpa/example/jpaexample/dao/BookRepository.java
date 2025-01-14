package com.bootjpa.example.jpaexample.dao;

import com.bootjpa.example.jpaexample.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
