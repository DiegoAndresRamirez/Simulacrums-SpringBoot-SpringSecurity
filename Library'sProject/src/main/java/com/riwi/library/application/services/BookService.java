package com.riwi.library.application.services;

import com.riwi.library.application.IModels.IModelBook;
import com.riwi.library.domain.models.Book;
import com.riwi.library.domain.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IModelBook {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public String create(String title, String author, String year, String description) {

        Book book = Book.builder()
                .title(title)
                .author(author)
                .year(year)
                .description(description)
                .build();

        bookRepository.save(book);
        return book.toString();
    }
}
