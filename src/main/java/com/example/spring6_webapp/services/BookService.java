package com.example.spring6_webapp.services;

import com.example.spring6_webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
