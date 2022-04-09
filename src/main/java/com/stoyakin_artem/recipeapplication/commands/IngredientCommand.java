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
    private Long recipeId;
    private BigDecimal amount;
    private RecipeCommand recipeCommand;
    private UnitOfMeasureCommand unitOfMeasureCommand;

    @Builder
    public IngredientCommand(Long id, String description, Long recipeId, BigDecimal amount, RecipeCommand recipeCommand, UnitOfMeasureCommand unitOfMeasureCommand) {
        super(id);
        this.description = description;
        this.recipeId = recipeId;
        this.amount = amount;
        this.recipeCommand = recipeCommand;
        this.unitOfMeasureCommand = unitOfMeasureCommand;
    }
}
