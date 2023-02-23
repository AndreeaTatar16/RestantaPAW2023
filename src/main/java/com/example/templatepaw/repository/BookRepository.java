package com.example.templatepaw.repository;

import com.example.templatepaw.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT DISTINCT b FROM Book b LEFT JOIN b.author a WHERE b.title LIKE %:keyword% OR b.year = :keyword OR a.name LIKE %:keyword% OR a.surname LIKE %:keyword%")
    List<Book> findByKeywordContaining(@Param("keyword") String keyword);
}
