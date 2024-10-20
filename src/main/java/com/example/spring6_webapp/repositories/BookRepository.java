package com.example.spring6_webapp.repositories;

import com.example.spring6_webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
