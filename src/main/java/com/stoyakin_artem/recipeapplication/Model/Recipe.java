package com.stoyakin_artem.recipeapplication.Model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recipe extends BaseEntity{


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

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany
    private Set<Category> categories = new HashSet<>();


    public void AddIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
    }


    public void setNotesO(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public void deleteIngredient(Ingredient ingredient){
        this.ingredients.remove(ingredient);
        ingredient.deleteRecipe();
    }


    protected boolean canEqual(final Object other) {
        return other instanceof Recipe;
    }

    @Builder
    public Recipe(Long id, String description, Integer prepTime, Integer cookTime, Integer servings, String url, String source, String direction, byte[] image, Notes notes, Set<Ingredient> ingredients, Difficulty difficulty, Set<Category> categories) {
        super(id);
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.url = url;
        this.source = source;
        this.direction = direction;
        this.image = image;
        this.notes = notes;
        this.ingredients = ingredients;
        this.difficulty = difficulty;
        this.categories = categories;
    }
}
