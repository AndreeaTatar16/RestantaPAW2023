package com.example.templatepaw.service;

import com.example.templatepaw.model.Book;
import com.example.templatepaw.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book create(Book book){

        return bookRepository.save(book);
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByKeywordContaining(String keyword) {
        return bookRepository.findByKeywordContaining(keyword);
    }

}
