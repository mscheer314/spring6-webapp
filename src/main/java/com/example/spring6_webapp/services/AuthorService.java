package com.example.spring6_webapp.services;

import com.example.spring6_webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
