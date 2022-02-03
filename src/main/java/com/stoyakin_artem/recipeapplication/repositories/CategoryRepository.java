package com.stoyakin_artem.recipeapplication.repositories;

import com.stoyakin_artem.recipeapplication.Model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByCategoryName(String categoryName);
}
