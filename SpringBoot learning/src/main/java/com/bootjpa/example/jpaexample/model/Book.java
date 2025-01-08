package com.bootjpa.example.jpaexample.model;

public class Book {

    int id;

    public Book() {
    }

    public Book(int id, String name, String author, String genre) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    String Name;
    String author;
    String Genre;
}
