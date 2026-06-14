package com.demo.graphql.book;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @MutationMapping
    Book addBook(@Argument BookInput book) {
        return bookService.addBook(book.title(), book.author());
    }

    record BookInput(String title, Long author) {
    }
}
