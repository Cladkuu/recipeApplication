package com.stoyakin_artem.recipeapplication.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category extends BaseEntity{

    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes = new HashSet<>();

    public Category() {
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
