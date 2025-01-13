package com.bootjpa.example.jpaexample.Service;

import com.bootjpa.example.jpaexample.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

    private static List<Book> list=new ArrayList<>();

    static {
//        list.add(new Book(1,"Hands-on Java","Ashok Singh","Information"));
//        list.add(new Book(2,"Love Hypothesis","Ali Hazelwood","Rom-Com"));
//        list.add(new Book(3,"Atomic habits","Anothey gustov","Self-Help"));
//        list.add(new Book(4,"The Subtle art of not giving a fuck","Mark Manson","Self-Help"));
//        list.add(new Book(5,"Cricket as Career was a mistake","Virat Kholi","Cricket"));
    }

    //get all books
    public List<Book> getAllBooks(){
        return list;
    }

    //get book by id
    public Book getBookById(int id){
        Book book=null;
        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

    // add book
    public Book addBook(Book b){
        list.add(b);
        return b;
    }

    // delete book handler
    public void deleteBook(int id){
       list=list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
    }

    public void updateBook(Book book,int id){
        list=list.stream().map(book1 -> {
            if(book1.getId()==id){
                book1.setName(book.getName());
                book1.setAuthor(book.getAuthor());
                book1.setGenre(book.getGenre());
            }
            return book1;
        }).collect(Collectors.toList());
    }
}
