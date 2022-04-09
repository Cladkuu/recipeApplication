package com.stoyakin_artem.recipeapplication.Controller;

import com.stoyakin_artem.recipeapplication.Model.Ingredient;
import com.stoyakin_artem.recipeapplication.commands.IngredientCommand;
import com.stoyakin_artem.recipeapplication.repositories.IngredientRepository;
import com.stoyakin_artem.recipeapplication.services.IngredientService;
import com.stoyakin_artem.recipeapplication.services.RecipeService;
import com.stoyakin_artem.recipeapplication.services.UoMService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"recipe/{recipeId}/ingredients/"})
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UoMService uoMService;
    private final IngredientRepository repository;

    @GetMapping
    public String GetIngredients(@PathVariable Long recipeId, Model model){
        log.debug("Getting all ingredients of " + recipeId);
        model.addAttribute("recipe", recipeService.FindRecipeCommandById(recipeId));

        return "recipe/ingredient/list";
    }

    @GetMapping("{ingredientId}")
    public String GetIngredient(@PathVariable Long ingredientId, Model model, @PathVariable Long recipeId){
        log.debug("Get single ingredient" + ingredientId);
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(recipeId, ingredientId));

        return "recipe/ingredient/show";
    }

    @GetMapping(value = {"{ingredientId}/update"})
    public String UpdateIngredient(@PathVariable Long ingredientId, Model model, @PathVariable Long recipeId){
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(recipeId, ingredientId));
        model.addAttribute("uomList", uoMService.AllUoMs());

        return "recipe/ingredient/ingredientform";
    }


    @PostMapping
    public IngredientCommand SaveOrUpdateIngredient(@PathVariable Long recipeId, @ModelAttribute IngredientCommand ingredientCommand, Model model){
        ingredientService.SaveOrUpdateIngredientCommand(ingredientCommand);


        return  ingredientCommand;
    }

    @DeleteMapping(value = {"{ingredientId}/delete"})
    public String DeleteIngredient(@PathVariable Long ingredientId, Model model, @PathVariable Long recipeId){


        return "redirect:/";
    }

}
