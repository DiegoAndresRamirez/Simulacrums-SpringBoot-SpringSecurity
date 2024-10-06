package com.riwi.library.application.services;

import com.riwi.library.application.IModels.IModelAutor;
import com.riwi.library.domain.models.Autor;
import com.riwi.library.domain.persistence.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService implements IModelAutor {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public String create(String name, String surname, String age, String description) {

        Autor autor = Autor.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .description(description)
                .build();

        autorRepository.save(autor);
        return autor.toString();
    }
}
