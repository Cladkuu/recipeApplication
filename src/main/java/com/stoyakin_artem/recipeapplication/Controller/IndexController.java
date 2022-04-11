package com.stoyakin_artem.recipeapplication.Controller;


import com.stoyakin_artem.recipeapplication.services.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"/", "default", ""})
public class IndexController {


    private final RecipeService recipeService;

    private static final String VIEWS_INDEX_SHOW = "index";

    @GetMapping
    public String findIndex(Model model) {
        log.debug("sending index.html");
        model.addAttribute("recipes", recipeService.recipes());
        return VIEWS_INDEX_SHOW;
    }

}
