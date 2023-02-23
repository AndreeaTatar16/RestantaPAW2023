package com.example.templatepaw.controller;

import com.example.templatepaw.model.Author;
import com.example.templatepaw.model.AuthorBookRequest;
import com.example.templatepaw.model.Book;
import com.example.templatepaw.repository.BookRepository;
import com.example.templatepaw.service.AuthorService;
import com.example.templatepaw.service.BookService;
import com.example.templatepaw.service.KeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private KeyWordService keyWordService;

    @PostMapping("/addBook")
    public ResponseEntity<?> createBook(@RequestBody Book book){
        Book newBook = bookService.create(book);

        return ResponseEntity.ok(newBook);
    }

    @GetMapping("/getBooks")
    public ResponseEntity<?> seeBooks() {
        Iterable<Book> books = bookService.findAll();

        return ResponseEntity.ok(books);
    }

    @PostMapping("/search")
    public List<Book> searchBooks(@RequestBody Map<String, String> book) {
        String keyword = book.get("keyword");
        return bookRepository.findByKeywordContaining(keyword);
    }

    @PostMapping("/addAuthor")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorBookRequest request){
        Author author = request.getAuthor();
        Book book = request.getBook();
        book.setAuthor(author);

        return ResponseEntity.ok(bookService.create(book));
    }

}
