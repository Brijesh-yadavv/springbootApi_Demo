package com.restapi.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.bootrestbook.Dao.BookRepo;
import com.restapi.bootrestbook.entities.Book;

@Component
public class BookService {

   

    @Autowired
    private BookRepo bookRepo;

    // get all books
    public List<Book> getAllBooks() {
        List<Book> list=(List<Book>) this.bookRepo.findAll();
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        try {
           
            return this.bookRepo.findById(id);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // adding the book to the server from client (Postman)
    public Book addBook(Book book) {
       Book b=this.bookRepo.save(book);
        return b;
    }

    // deleting the book on the server after requesting from the client
    public void deleteBookById(int id) {
        this.bookRepo.deleteById(id);
    }


    public void deleteAll(){
        this.bookRepo.deleteAll();
    }

    // update the book
    public void updateBook(Book book, int id) {
        book.setId(id);
       this.bookRepo.save(book);

    }

}
