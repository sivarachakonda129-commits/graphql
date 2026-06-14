package com.demo.graphql.book;

import com.demo.graphql.author.Author;
import com.demo.graphql.author.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public Book addBook(String title, Long authorId) {
        Author author = authorService.findAuthorById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id!"));
        return bookRepository.save(new Book(null, title, author));
    }
}
