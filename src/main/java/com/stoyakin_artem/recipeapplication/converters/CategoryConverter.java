package com.stoyakin_artem.recipeapplication.converters;
import com.stoyakin_artem.recipeapplication.Model.Category;
import com.stoyakin_artem.recipeapplication.commands.CategoryCommand;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<CategoryCommand, Category>{
    @Override
    public CategoryCommand convertToCommand(Category category) {
        if (category==null) return null;
        return CategoryCommand.builder()
                .categoryName(category.getCategoryName())
                .id(category.getId()).build();
    }

    @Override
    public Category convertToEntity(CategoryCommand categoryCommand) {
        if (categoryCommand==null) return null;
        return Category.builder()
                .categoryName(categoryCommand.getCategoryName())
                .id(categoryCommand.getId())
                .build();
    }
}
