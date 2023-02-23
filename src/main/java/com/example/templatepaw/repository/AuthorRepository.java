package com.example.templatepaw.repository;

import com.example.templatepaw.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
