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
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String age;

    private String description;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private Set<AutorBook> books;
}
