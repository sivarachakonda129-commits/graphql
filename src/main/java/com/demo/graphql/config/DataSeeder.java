package com.demo.graphql.config;

import com.demo.graphql.author.Author;
import com.demo.graphql.author.AuthorService;
import com.demo.graphql.book.BookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    ApplicationRunner applicationRunner(AuthorService authorService, BookService bookService) {
        return args -> {
            Author uncleBob = authorService.createAuthor("Uncle Bob");
            Author martinK = authorService.createAuthor("Martin K");

            bookService.addBook("Clean Code", uncleBob.getId());
            bookService.addBook("Clean Architecture", uncleBob.getId());
            bookService.addBook("Designing Data-Intensive Applications", martinK.getId());
        };
    }
}
