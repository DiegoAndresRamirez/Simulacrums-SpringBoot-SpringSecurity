package com.riwi.library.application.services;

import com.riwi.library.application.IModels.IModelCategory;
import com.riwi.library.domain.models.Category;
import com.riwi.library.domain.persistence.CategoryRepository;
import com.riwi.library.infrastructure.dto.request.categoryRequestDtos.CategoryCreateRequestDTO;
import com.riwi.library.infrastructure.dto.response.categoryResponseDtos.CategoryCreateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements IModelCategory {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryCreateResponseDTO create(CategoryCreateRequestDTO categoryCreateRequestDTO) {

        Category category = Category.builder()
                .name(categoryCreateRequestDTO.getName())
                .description(categoryCreateRequestDTO.getDescription())
                .build();

        categoryRepository.save(category);
        return CategoryCreateResponseDTO.builder()
                .name(category.getName())
                .description(category.getDescription())
                .build();

    }
}
