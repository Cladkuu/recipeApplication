package com.stoyakin_artem.recipeapplication.Controller;

import com.stoyakin_artem.recipeapplication.Model.Category;
import com.stoyakin_artem.recipeapplication.Model.Recipe;
import com.stoyakin_artem.recipeapplication.Model.UnitOfMeasure;
import com.stoyakin_artem.recipeapplication.repositories.CategoryRepository;
import com.stoyakin_artem.recipeapplication.repositories.UnitOfMeasureRepository;
import com.stoyakin_artem.recipeapplication.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(value = {"/", "default", ""})
public class IndexController {


    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public String findIndex(Model model) {
        model.addAttribute("recipes", recipeService.recipes());
        return "index";
    }

}
