package com.stoyakin_artem.recipeapplication.commands;

import com.stoyakin_artem.recipeapplication.Model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeCommand extends BaseEntity {


    @Lob
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String url;
    private String source;
    private String direction;

    @Lob
    private byte[] image;
    private NotesCommand notesCommand;
    private Set<IngredientCommand> ingredientCommands = new HashSet<>();
    private Difficulty difficulty;
    private Set<CategoryCommand> categoryCommands = new HashSet<>();


    @Builder
    public RecipeCommand(Long id, String description, Integer prepTime, Integer cookTime, Integer servings,
                         String url, String source, String direction, byte[] image, NotesCommand notesCommand,
                         Set<IngredientCommand> ingredientCommands, Difficulty difficulty,
                         Set<CategoryCommand> categoryCommands) {
        super(id);
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.url = url;
        this.source = source;
        this.direction = direction;
        this.image = image;
        this.notesCommand = notesCommand;
        this.ingredientCommands = ingredientCommands;
        this.difficulty = difficulty;
        this.categoryCommands = categoryCommands;
    }
}
