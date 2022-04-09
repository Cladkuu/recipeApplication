package com.stoyakin_artem.recipeapplication.converters;
import com.stoyakin_artem.recipeapplication.Model.Ingredient;
import com.stoyakin_artem.recipeapplication.commands.IngredientCommand;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class IngredientConverter implements Converter<IngredientCommand, Ingredient>{

    private final UnitOfMeasureConverter unitOfMeasureConverter;
    //private final RecipesConverter recipesConverter;


    @Synchronized
    @Override
    public IngredientCommand convertToCommand(Ingredient ingredient) {
        if (ingredient==null) return null;
        return IngredientCommand.builder()
                .description(ingredient.getDescription())
                .recipeId(ingredient.getRecipe().getId())
                .amount(ingredient.getAmount())
                .id(ingredient.getId())
                .unitOfMeasureCommand(unitOfMeasureConverter.convertToCommand(ingredient.getUnitOfMeasure()))
                //.recipeCommand(recipesConverter.convertToCommand(ingredient.getRecipe()))
                .build();
    }

    @Synchronized
    @Override
    public Ingredient convertToEntity(IngredientCommand ingredientCommand) {
        if (ingredientCommand==null) return null;
        return Ingredient.builder()
                .description(ingredientCommand.getDescription())
                .amount(ingredientCommand.getAmount())
                //.recipe(recipesConverter.convertToEntity(ingredientCommand.getRecipeCommand()))
                .unitOfMeasure(unitOfMeasureConverter.convertToEntity(ingredientCommand.getUnitOfMeasureCommand()))
                .id(ingredientCommand.getId())
                .build();
    }
}
