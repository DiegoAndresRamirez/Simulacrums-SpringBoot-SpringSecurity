package com.riwi.library.domain.persistence;

import com.riwi.library.domain.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
