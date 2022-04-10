package com.stoyakin_artem.recipeapplication.services;

import com.stoyakin_artem.recipeapplication.Model.Ingredient;
import com.stoyakin_artem.recipeapplication.Model.Recipe;
import com.stoyakin_artem.recipeapplication.commands.IngredientCommand;
import com.stoyakin_artem.recipeapplication.converters.IngredientConverter;
import com.stoyakin_artem.recipeapplication.repositories.IngredientRepository;
import com.stoyakin_artem.recipeapplication.repositories.RecipeRepository;
import com.stoyakin_artem.recipeapplication.repositories.UnitOfMeasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class IngredientServiceImpl implements IngredientService {


    private final IngredientConverter ingredientConverter;
    private final RecipeService recipeService;
    private final IngredientRepository repository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Recipe reqRecipe = recipeService.findById(recipeId);

        return reqRecipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientConverter.convertToCommand(ingredient)).findFirst().orElse(null);
    }

    @Override
    public IngredientCommand SaveOrUpdateIngredientCommand(IngredientCommand ingredientCommand) {

        Recipe recipe = recipeService.findById(ingredientCommand.getRecipeId());

        Ingredient ingredient = recipe.getIngredients().stream()
                .filter(ingredient1 -> ingredient1.getId().equals(ingredientCommand.getRecipeId()))
                .findFirst().orElse(null);

        if(ingredient==null){
            recipe.AddIngredient(ingredientConverter.convertToEntity(ingredientCommand));

        }
        else {
            ingredient.setDescription(ingredientCommand.getDescription());
            ingredient.setAmount(ingredientCommand.getAmount());
            //ingredient.setUnitOfMeasure(unitOfMeasureRepository.findById(ingredientCommand.getUnitOfMeasureCommand().getId()).orElse(null));

        }

        recipeRepository.save(recipe);
        return ingredientConverter.convertToCommand(ingredient);
    }

    public void deleteIngredient(Long recipeId, Long ingredientId){
        Recipe recipe = recipeService.findById(recipeId);
        if(recipe!=null)
        {
            Ingredient ingredient = recipe.getIngredients().stream()
                    .filter(ingredient1 -> ingredient1.getId().equals(ingredientId))
                    .findFirst().orElse(null);

            if(ingredient!=null){
                recipe.deleteIngredient(ingredient);
                recipeRepository.save(recipe);
                repository.deleteById(ingredientId);
            }
        }

    }
}
