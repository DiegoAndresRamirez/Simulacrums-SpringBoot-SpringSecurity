package com.riwi.library.application.services;

import com.riwi.library.application.IModels.IModelAutor;
import com.riwi.library.domain.models.Autor;
import com.riwi.library.domain.persistence.AutorRepository;
import com.riwi.library.infrastructure.dto.request.AutorCreateRequestDTO;
import com.riwi.library.infrastructure.dto.response.AutorCreateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService implements IModelAutor {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public AutorCreateResponseDTO create(AutorCreateRequestDTO autorCreateRequestDTO) {

        Autor autor = Autor.builder()
                .name(autorCreateRequestDTO.getName())
                .surname(autorCreateRequestDTO.getSurname())
                .age(autorCreateRequestDTO.getAge())
                .description(autorCreateRequestDTO.getDescription())
                .build();

        autorRepository.save(autor);


        return AutorCreateResponseDTO.builder()
                .name(autor.getName())
                .description(autor.getDescription())
                .build();
    }
}
