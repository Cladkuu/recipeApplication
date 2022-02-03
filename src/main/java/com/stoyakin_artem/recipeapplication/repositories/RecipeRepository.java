package com.stoyakin_artem.recipeapplication.repositories;

import com.stoyakin_artem.recipeapplication.Model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
