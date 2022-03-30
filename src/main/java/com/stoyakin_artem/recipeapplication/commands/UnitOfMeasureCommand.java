package com.stoyakin_artem.recipeapplication.commands;

import com.stoyakin_artem.recipeapplication.Model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitOfMeasureCommand extends BaseEntity {

    private String description;

    @Builder
    public UnitOfMeasureCommand(Long id, String description) {
        super(id);
        this.description = description;
    }
}
