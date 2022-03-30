package com.stoyakin_artem.recipeapplication.converters;
import com.stoyakin_artem.recipeapplication.Model.Category;
import com.stoyakin_artem.recipeapplication.Model.UnitOfMeasure;
import com.stoyakin_artem.recipeapplication.commands.CategoryCommand;
import com.stoyakin_artem.recipeapplication.commands.UnitOfMeasureCommand;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureConverter implements Converter<UnitOfMeasureCommand, UnitOfMeasure>{

    @Override
    public UnitOfMeasureCommand convertToCommand(UnitOfMeasure unitOfMeasure) {
        if (unitOfMeasure==null) return null;
        return UnitOfMeasureCommand.builder()
                .id(unitOfMeasure.getId())
                .description(unitOfMeasure.getDescription())
                .build();
    }

    @Override
    public UnitOfMeasure convertToEntity(UnitOfMeasureCommand unitOfMeasureCommand) {
        if (unitOfMeasureCommand==null) return null;
        return UnitOfMeasure.builder()
                .id(unitOfMeasureCommand.getId())
                .description(unitOfMeasureCommand.getDescription())
                .build();
    }
}
