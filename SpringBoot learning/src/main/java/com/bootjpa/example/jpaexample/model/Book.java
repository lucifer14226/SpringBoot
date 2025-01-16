package com.bootjpa.example.jpaexample.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    int id;

    String Name;
    String Genre;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;

    public Book() {
    }

    public Book(int id, String name, Author author, String genre) {
        this.id = id;
        Name = name;
        this.author = author;
        Genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }


}
