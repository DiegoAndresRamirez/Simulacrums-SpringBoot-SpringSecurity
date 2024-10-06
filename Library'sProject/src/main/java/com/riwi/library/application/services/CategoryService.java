package com.riwi.library.application.services;

import com.riwi.library.application.IModels.IModelCategory;
import com.riwi.library.domain.models.Category;
import com.riwi.library.domain.persistence.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements IModelCategory {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public String create(String name, String description) {

        Category category = Category.builder()
                .name(name)
                .description(description)
                .build();

        categoryRepository.save(category);
        return category.toString();

    }
}
