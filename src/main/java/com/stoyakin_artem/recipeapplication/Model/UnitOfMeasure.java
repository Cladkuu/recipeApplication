package com.stoyakin_artem.recipeapplication.Model;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
public class UnitOfMeasure extends BaseEntity{

    private String description;

    public UnitOfMeasure() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UnitOfMeasure;
    }

}
