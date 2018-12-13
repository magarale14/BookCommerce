package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Book;
import com.example.easynotes.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ecommerce")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

   /* @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    } */

    @GetMapping("/books/{_id}")
    //@CrossOrigin(origins = "http://localhost:8080")
    public Book getBookById(@PathVariable(value = "_id") Integer bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "_id", bookId));
    }

}
