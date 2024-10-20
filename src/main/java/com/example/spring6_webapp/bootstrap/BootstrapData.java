package com.example.spring6_webapp.bootstrap;

import com.example.spring6_webapp.domain.Author;
import com.example.spring6_webapp.domain.Book;
import com.example.spring6_webapp.domain.Publisher;
import com.example.spring6_webapp.repositories.AuthorRepository;
import com.example.spring6_webapp.repositories.BookRepository;
import com.example.spring6_webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author tolkien = new Author();
        tolkien.setFirstName("JRR");
        tolkien.setLastName("Tolkien");

        Author lewis = new Author();
        lewis.setFirstName("CS");
        lewis.setLastName("Lewis");

        Publisher miflin = new Publisher();
        miflin.setName("Miflin");
        miflin.setAddress("123 Main St");
        miflin.setCity("Chicago");
        miflin.setState("IL");
        miflin.setZip("33222");

        Book lotr = new Book();
        lotr.setTitle("Lord of the Rings");
        lotr.setIsbn("123456");

        Book perelandra = new Book();
        perelandra.setTitle("Perelandra");
        perelandra.setIsbn("987654321");

        Author tolkienSaved = authorRepository.save(tolkien);
        Author lewisSaved = authorRepository.save(lewis);

        Book lotrSaved = bookRepository.save(lotr);
        Book perelandraSaved = bookRepository.save(perelandra);

        Publisher miflinSaved = publisherRepository.save(miflin);

        tolkienSaved.getBooks().add(lotrSaved);
        lewisSaved.getBooks().add(perelandraSaved);

        lotrSaved.setPublisher(miflinSaved);
        perelandraSaved.setPublisher(miflinSaved);

        authorRepository.save(tolkienSaved);
        authorRepository.save(lewisSaved);

        bookRepository.save(lotrSaved);
        bookRepository.save(perelandraSaved);

        System.out.println("In Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
