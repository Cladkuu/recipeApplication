package com.stoyakin_artem.recipeapplication.Controller;

import com.stoyakin_artem.recipeapplication.Model.Recipe;
import com.stoyakin_artem.recipeapplication.commands.RecipeCommand;
import com.stoyakin_artem.recipeapplication.services.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping(value = {"recipe/"})
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    private static final String VIEWS_RECIPE_SHOW = "recipe/show";
    private static final String VIEWS_RECIPE_RECIPE_FORM = "recipe/recipeform";


    @GetMapping(value = {"{id}"})
    public String getRecipe(@PathVariable Long id, Model model){
        model.addAttribute("recipe", recipeService.findById(id));
        return VIEWS_RECIPE_SHOW;
    }


    @GetMapping("new")
    public String NewRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        return VIEWS_RECIPE_RECIPE_FORM;
    }

    @GetMapping("{id}/update")
    public String updateRecipe(@PathVariable Long id, Model model){
        model.addAttribute("recipe", recipeService.FindRecipeCommandById(id));
        return VIEWS_RECIPE_RECIPE_FORM;
    }

    @PostMapping
    public String saveOrUpdateRecipe( RecipeCommand recipeCommand){
        RecipeCommand savedRecipe = recipeService.SaveRecipe(recipeCommand);
        return "redirect:" + savedRecipe.getId();
    }

    @GetMapping
    @RequestMapping("{id}/delete")
    public String deleteRecipe(@PathVariable Long id){
        log.debug("deleting Recipe " + id);
        recipeService.deleteById(id);
        return "redirect:/";
    }

}
