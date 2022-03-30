package com.stoyakin_artem.recipeapplication.Model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseEntity{

    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes = new HashSet<>();

    @Builder
    public Category(Long id, String categoryName, Set<Recipe> recipes) {
        super(id);
        this.categoryName = categoryName;
        this.recipes = recipes;
    }
}
