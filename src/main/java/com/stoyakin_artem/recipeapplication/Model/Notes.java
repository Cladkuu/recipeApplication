package com.stoyakin_artem.recipeapplication.Model;

import javax.persistence.*;

@Entity
public class Notes extends BaseEntity{


    @Lob
    private String recipeNotes;

    public Notes() {
    }

    @OneToOne(mappedBy = "notes")
    private Recipe recipe;



    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
