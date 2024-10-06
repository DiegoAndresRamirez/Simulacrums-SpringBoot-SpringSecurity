package com.riwi.library.domain.models;


import com.riwi.library.domain.intermediate.AutorBook;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String year;

    private String description;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<AutorBook> autors;
}
