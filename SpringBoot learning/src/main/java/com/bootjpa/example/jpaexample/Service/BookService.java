package com.bootjpa.example.jpaexample.Service;

import com.bootjpa.example.jpaexample.dao.BookRepository;
import com.bootjpa.example.jpaexample.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;


@Component
public class BookService {

   @Autowired
   private BookRepository bookRepository;


    //get all books
    public List<Book> getAllBooks(){
        return (List<Book>) this.bookRepository.findAll();
    }

    //get book by id
    public Book getBookById(int id){
        Book book=null;
        book=this.bookRepository.findById(id);
        return book;
    }

    // add book
    public Book addBook(Book b){
        Book result=bookRepository.save(b);
        return result;
    }

    // delete book handler
    public void deleteBook(int id){
       this.bookRepository.deleteById(id);
    }

    public void updateBook(Book book,int id){
        book.setId(id);
        this.bookRepository.save(book);
    }
}
