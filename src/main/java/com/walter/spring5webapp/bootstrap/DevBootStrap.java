package com.walter.spring5webapp.bootstrap;

import com.walter.spring5webapp.model.Author;
import com.walter.spring5webapp.model.Book;
import com.walter.spring5webapp.model.respositories.AuthorRepository;
import com.walter.spring5webapp.model.respositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){
        Author a1 = new Author("Walter", "Williams");
        Book b1 = new Book("My First Book","1234","ROC");
        b1.getAuthors().add(a1);
        a1.getBooks().add(b1);

        authorRepository.save(a1);
        bookRepository.save(b1);


        Author a2 = new Author("Joey", "Westerfield");
        Book b2 = new Book("Powershell in Action", "2345","Manning");
        b2.getAuthors().add(a2);
        a2.getBooks().add(b2);

        authorRepository.save(a2);
        bookRepository.save(b2);
    }
}
