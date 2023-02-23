package com.example.templatepaw.repository;

import com.example.templatepaw.model.Book;
import com.example.templatepaw.model.KeyWord;
import org.springframework.data.repository.CrudRepository;

public interface KeyWordRepository extends CrudRepository<KeyWord, Long> {
}
