package com.stoyakin_artem.recipeapplication.converters;

public interface Converter<Dto, Entity> {
    Dto convertToCommand(Entity entity);

    Entity convertToEntity(Dto dto);


}
