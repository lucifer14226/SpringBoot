package com.bootjpa.example.jpaexample.Controller;

import com.bootjpa.example.jpaexample.Service.BookService;
import com.bootjpa.example.jpaexample.model.Book;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBookHandler(){
        List<Book> result=bookService.getAllBooks();
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(result));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBooksHandler(@PathVariable("id")int id){
        Book result=bookService.getBookById(id);
        if(result==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(result));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBookHandler(@RequestBody Book book){
        Book b=null;
        try {
            b=bookService.addBook(book);
            return ResponseEntity.of(Optional.of(b));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBookHandler(@PathVariable("bookId") int bookId){
        try {
            this.bookService.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Void> updateBookHandle(@RequestBody Book book,@PathVariable("bookId") int bookId){
        try {
            this.bookService.updateBook(book,bookId);
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
