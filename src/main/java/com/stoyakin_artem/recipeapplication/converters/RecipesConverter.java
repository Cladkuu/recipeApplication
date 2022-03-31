package com.stoyakin_artem.recipeapplication.converters;
import com.stoyakin_artem.recipeapplication.Model.Category;
import com.stoyakin_artem.recipeapplication.Model.Recipe;
import com.stoyakin_artem.recipeapplication.commands.CategoryCommand;
import com.stoyakin_artem.recipeapplication.commands.RecipeCommand;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RecipesConverter implements Converter<RecipeCommand, Recipe>{

    private final NotesConverter notesConverter;
    private final CategoryConverter categoryConverter;
    private final IngredientConverter ingredientConverter;

    @Synchronized
    @Override
    public RecipeCommand convertToCommand(Recipe recipe) {
        if (recipe==null) return null;
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(recipe.getId());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setCookTime(recipe.getCookTime());
        recipeCommand.setPrepTime(recipe.getPrepTime());
        recipeCommand.setDifficulty(recipe.getDifficulty());
        recipeCommand.setDirection(recipe.getDirection());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setUrl(recipe.getUrl());
        recipeCommand.setNotesCommand(notesConverter.convertToCommand(recipe.getNotes()));

        if (recipe.getIngredients()!=null & recipe.getIngredients().size()>0){
            recipe.getIngredients().forEach(ingredient -> recipeCommand
                    .getIngredientCommands().add(ingredientConverter.convertToCommand(ingredient)));
        }

        if (recipe.getCategories()!=null & recipe.getCategories().size()>0){
            recipe.getCategories().forEach(category -> recipeCommand.getCategoryCommands()
                    .add(categoryConverter.convertToCommand(category)));
        }
        return recipeCommand;
    }

    @Synchronized
    @Override
    public Recipe convertToEntity(RecipeCommand recipeCommand) {
        if (recipeCommand==null) return null;
        final Recipe recipe = new Recipe();
        recipe.setId(recipeCommand.getId());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setDifficulty(recipeCommand.getDifficulty());
        recipe.setDirection(recipeCommand.getDirection());
        recipe.setServings(recipeCommand.getServings());
        recipe.setSource(recipeCommand.getSource());
        recipe.setUrl(recipeCommand.getUrl());
        recipe.setNotes(notesConverter.convertToEntity(recipeCommand.getNotesCommand()));

        if (recipeCommand.getIngredientCommands()!=null & recipeCommand.getIngredientCommands().size()>0){
            recipeCommand.getIngredientCommands().forEach(ingredient -> recipe
                    .getIngredients().add(ingredientConverter.convertToEntity(ingredient)));
        }

        if (recipeCommand.getCategoryCommands()!=null & recipeCommand.getCategoryCommands().size()>0){
            recipeCommand.getCategoryCommands().forEach(category -> recipe.getCategories()
                    .add(categoryConverter.convertToEntity(category)));
        }
        return recipe;

    }
}
