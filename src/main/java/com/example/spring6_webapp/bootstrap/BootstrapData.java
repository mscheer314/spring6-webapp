package com.example.spring6_webapp.bootstrap;

import com.example.spring6_webapp.domain.Author;
import com.example.spring6_webapp.domain.Book;
import com.example.spring6_webapp.repositories.AuthorRepository;
import com.example.spring6_webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author tolkien = new Author();
        tolkien.setFirstName("JRR");
        tolkien.setLastName("Tolkien");

        Author lewis = new Author();
        lewis.setFirstName("CS");
        lewis.setLastName("Lewis");

        Book lotr = new Book();
        lotr.setTitle("Lord of the Rings");
        lotr.setIsbn("123456");

        Book perelandra = new Book();
        perelandra.setTitle("Perelandra");
        perelandra.setIsbn("987654321");

        Author tolkienSaved = authorRepository.save(tolkien);
        Author lewisSaved = authorRepository.save(lewis);

        authorRepository.save(tolkienSaved);
        authorRepository.save(lewisSaved);

        Book lotrSaved = bookRepository.save(lotr);
        Book perelandraSaved = bookRepository.save(perelandra);

        tolkienSaved.getBooks().add(lotrSaved);
        lewisSaved.getBooks().add(perelandraSaved);

        System.out.println("In Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
    }
}
