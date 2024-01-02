package com.restapi.bootrestbook.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.bootrestbook.entities.Book;
import com.restapi.bootrestbook.services.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> list = this.bookService.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(list);

        }

    }

    // this get method returns the books from the server to the client

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        Book bo = this.bookService.getBookById(id);
        if (bo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        } else {
            return ResponseEntity.of(Optional.of(bo));
        }
    }

    // this Post method is used to get the data from the client(Postman) and store
    // to the server or db.
    @PostMapping("/book")
    public ResponseEntity addBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookService.addBook(book); 
            return ResponseEntity.ok(Optional.of(b));
        } catch (Exception e) {
           
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // delete book hander

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Void> delteBook(@PathVariable("id") int id) {
        try {
            this.bookService.deleteBookById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception e) {
           
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // upadting the book handler

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {

        try {
            this.bookService.updateBook(book, bookId);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
           
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
