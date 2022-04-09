package com.stoyakin_artem.recipeapplication.Controller;

import com.stoyakin_artem.recipeapplication.services.IngredientService;
import com.stoyakin_artem.recipeapplication.services.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"recipe/{recipeId}/ingredients/"})
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;

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

}
