package com.stoyakin_artem.recipeapplication.Bootstrap;

import com.stoyakin_artem.recipeapplication.Model.*;
import com.stoyakin_artem.recipeapplication.repositories.CategoryRepository;
import com.stoyakin_artem.recipeapplication.repositories.RecipeRepository;
import com.stoyakin_artem.recipeapplication.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class Bootstrap implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private  final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;

    public Bootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        recipeRepository.save(makingRecipe());
        System.out.println("Loading data");

    }

    private Recipe makingRecipe() {

        //get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if(!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if(!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!cupsUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        //get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teapoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = dashUomOptional.get();
        UnitOfMeasure cupsUom = cupsUomOptional.get();

        Optional<Category> americanOptional = categoryRepository.findByCategoryName("American");
        if(!americanOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }
        Optional<Category> MexicanOptional = categoryRepository.findByCategoryName("Mexican");
        if(!MexicanOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }
        Category american = americanOptional.get();
        Category mexican = MexicanOptional.get();


        Recipe recipe = new Recipe();
        recipe.setDescription("Be careful handling chilis! If using, it's best to wear food-safe gloves. If no gloves are available, wash your hands thoroughly after handling, and do not touch your eyes or the area near your eyes for several hours afterwards.");
        recipe.setPrepTime(10);
        recipe.setCookTime(10);
        recipe.setServings(2);
        recipe.setDifficulty(Difficulty.MODERATE);
        recipe.getCategories().add(american);
        recipe.getCategories().add(mexican);

        Notes notes1 = new Notes();
        notes1.setRecipeNotes("recipeNotes");
        notes1.setRecipe(recipe);
        recipe.setNotes(notes1);

        Ingredient avocado = new Ingredient();
        avocado.setAmount(new BigDecimal(2));
        avocado.setDescription("Avocado");
        avocado.setUnitOfMeasure(eachUom);
        avocado.setRecipe(recipe);

        Ingredient salt = new Ingredient();
        salt.setAmount(new BigDecimal(2));
        salt.setDescription("salt");
        salt.setUnitOfMeasure(tableSpoonUom);
        salt.setRecipe(recipe);

        Ingredient lime = new Ingredient();
        lime.setAmount(new BigDecimal(2));
        lime.setDescription("lime");
        lime.setUnitOfMeasure(dashUom);
        lime.setRecipe(recipe);

        recipe.getIngredients().add(avocado);
        recipe.getIngredients().add(salt);
        recipe.getIngredients().add(lime);

        return recipe;

    }
}
