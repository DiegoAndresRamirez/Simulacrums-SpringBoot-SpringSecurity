package com.riwi.library.domain.persistence;

import com.riwi.library.domain.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
