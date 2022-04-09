package com.stoyakin_artem.recipeapplication.repositories;

import com.stoyakin_artem.recipeapplication.Model.Ingredient;
import com.stoyakin_artem.recipeapplication.Model.UnitOfMeasure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;

import java.math.BigDecimal;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    @Query("update Ingredient set description= :desc, amount= :am")
    Ingredient updateIngredient(String desc, BigDecimal am);
}
