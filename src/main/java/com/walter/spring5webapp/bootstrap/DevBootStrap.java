package com.walter.spring5webapp.bootstrap;

import com.walter.spring5webapp.model.Author;
import com.walter.spring5webapp.model.Book;
import com.walter.spring5webapp.model.Publisher;
import com.walter.spring5webapp.model.respositories.AuthorRepository;
import com.walter.spring5webapp.model.respositories.BookRepository;
import com.walter.spring5webapp.model.respositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){
        Publisher p1 = new Publisher("ROC");
        Publisher p2 = new Publisher("Manning");
        publisherRepository.save(p1);
        publisherRepository.save(p2);
        Author a1 = new Author("Walter", "Williams");
        Book b1 = new Book("My First Book","1234",p1);
        b1.getAuthors().add(a1);
        a1.getBooks().add(b1);

        authorRepository.save(a1);
        bookRepository.save(b1);

        Author a2 = new Author("Joey", "Westerfield");
        Book b2 = new Book("Powershell in Action", "2345",p2);
        b2.getAuthors().add(a2);
        a2.getBooks().add(b2);

        authorRepository.save(a2);
        bookRepository.save(b2);

    }
}
