package com.stoyakin_artem.recipeapplication.Model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
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


    public Recipe() {
    }

    public void AddIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
    }


    public void setNotesO(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Recipe;
    }

}
