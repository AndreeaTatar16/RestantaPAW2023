package com.example.templatepaw.service;

import com.example.templatepaw.model.KeyWord;
import com.example.templatepaw.repository.KeyWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyWordService {
    @Autowired
    private KeyWordRepository keyWordRepository;

    public KeyWord create(KeyWord keyWord){

        return keyWordRepository.save(keyWord);
    }
}
