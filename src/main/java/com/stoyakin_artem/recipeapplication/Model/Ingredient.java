package com.stoyakin_artem.recipeapplication.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient extends BaseEntity{


    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;


    @OneToOne
    private UnitOfMeasure unitOfMeasure;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Ingredient;
    }

}
