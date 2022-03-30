package com.stoyakin_artem.recipeapplication.commands;

import com.stoyakin_artem.recipeapplication.Model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCommand extends BaseEntity {
    private String categoryName;

    @Builder
    public CategoryCommand(Long id, String categoryName) {
        super(id);
        this.categoryName = categoryName;
    }
}
