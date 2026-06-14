package com.demo.graphql.author;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public List<Author> authors() {
        return authorService.findAllAuthors();
    }

    @QueryMapping
    Optional<Author> authorById(@Argument Long id) {
        return authorService.findAuthorById(id);
    }

    @MutationMapping
    Author addAuthor(@Argument String name) {
        return authorService.createAuthor(name);
    }


}
