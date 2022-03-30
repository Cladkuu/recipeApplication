package com.stoyakin_artem.recipeapplication.commands;

import com.stoyakin_artem.recipeapplication.Model.BaseEntity;
import com.stoyakin_artem.recipeapplication.Model.Recipe;

import lombok.*;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipeCommand"})
@NoArgsConstructor
@AllArgsConstructor
public class IngredientCommand extends BaseEntity {

    private String description;
    private BigDecimal amount;
    private RecipeCommand recipeCommand;
    private UnitOfMeasureCommand unitOfMeasureCommand;

    @Builder
    public IngredientCommand(Long id, String description, BigDecimal amount, RecipeCommand recipeCommand, UnitOfMeasureCommand unitOfMeasureCommand) {
        super(id);
        this.description = description;
        this.amount = amount;
        this.recipeCommand = recipeCommand;
        this.unitOfMeasureCommand = unitOfMeasureCommand;
    }
}
