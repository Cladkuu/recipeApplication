package com.stoyakin_artem.recipeapplication.Model;

import lombok.*;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UnitOfMeasure extends BaseEntity{

    private String description;

    protected boolean canEqual(final Object other) {
        return other instanceof UnitOfMeasure;
    }

}
