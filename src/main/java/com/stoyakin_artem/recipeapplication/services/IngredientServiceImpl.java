package com.stoyakin_artem.recipeapplication.services;

import com.stoyakin_artem.recipeapplication.Model.Recipe;
import com.stoyakin_artem.recipeapplication.commands.IngredientCommand;
import com.stoyakin_artem.recipeapplication.converters.IngredientConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IngredientServiceImpl implements IngredientService {


    private final IngredientConverter ingredientConverter;
    private final RecipeService recipeService;

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Recipe reqRecipe = recipeService.findById(recipeId);

        return reqRecipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientConverter.convertToCommand(ingredient)).findFirst().orElse(null);
    }
}
