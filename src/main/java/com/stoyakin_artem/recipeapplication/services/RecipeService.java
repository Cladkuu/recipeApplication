package com.stoyakin_artem.recipeapplication.services;

import com.stoyakin_artem.recipeapplication.Model.Recipe;
import com.stoyakin_artem.recipeapplication.commands.RecipeCommand;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Transactional
public interface RecipeService {
    Set<Recipe> recipes();

    Recipe findById(Long id);

    RecipeCommand SaveRecipe(RecipeCommand recipeCommand);
}
