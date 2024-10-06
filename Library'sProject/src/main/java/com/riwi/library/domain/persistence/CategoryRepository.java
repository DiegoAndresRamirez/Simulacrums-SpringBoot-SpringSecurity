package com.riwi.library.domain.persistence;

import com.riwi.library.domain.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}