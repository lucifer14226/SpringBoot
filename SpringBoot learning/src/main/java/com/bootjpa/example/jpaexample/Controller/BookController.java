package com.bootjpa.example.jpaexample.Controller;

import com.bootjpa.example.jpaexample.Service.BookService;
import com.bootjpa.example.jpaexample.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBookHandler(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBooksHandler(@PathVariable("id")int id){
        return this.bookService.getBookById(id);
    }

    @PostMapping("/books")
    public Book addBookHandler(@RequestBody Book book){
        this.bookService.addBook(book);
        return book;
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBookHandler(@PathVariable("bookId") int bookId){
        this.bookService.deleteBook(bookId);
    }

    @PutMapping("/books/{bookId}")
    public void updateBookHandle(@RequestBody Book book,@PathVariable("bookId") int bookId){
        this.bookService.updateBook(book,bookId);
    }

}
