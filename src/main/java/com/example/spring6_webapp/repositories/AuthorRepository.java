package com.example.spring6_webapp.repositories;
import com.example.spring6_webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
