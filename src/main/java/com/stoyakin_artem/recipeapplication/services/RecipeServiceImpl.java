package com.stoyakin_artem.recipeapplication.services;

import com.stoyakin_artem.recipeapplication.Model.Recipe;
import com.stoyakin_artem.recipeapplication.commands.RecipeCommand;
import com.stoyakin_artem.recipeapplication.converters.RecipesConverter;
import com.stoyakin_artem.recipeapplication.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipesConverter recipesConverter;

    @Override
    public Set<Recipe> recipes() {
        log.debug("I'm using logger");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    @Override
    public RecipeCommand SaveRecipe(RecipeCommand recipeCommand) {
        Recipe recipe = recipeRepository.save(recipesConverter.convertToEntity(recipeCommand));
        log.debug("Saved recipe ID : " + recipe.getId());
        return recipesConverter.convertToCommand(recipe);
    }


}
