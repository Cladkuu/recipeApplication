package com.stoyakin_artem.recipeapplication.Controller;

import com.stoyakin_artem.recipeapplication.commands.RecipeCommand;
import com.stoyakin_artem.recipeapplication.services.ImageService;
import com.stoyakin_artem.recipeapplication.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"recipe/"})
public class ImageController {

    private final ImageService imageService;
    private final RecipeService recipeService;

    private static final String VIEWS_IMAGE_UPLOAD_FORM = "recipe/imageuploadform";

    @GetMapping(value = {"{recipeId}/image"})
    public String GetImageWindow(@PathVariable Long recipeId, Model model){
        model.addAttribute("recipe", recipeService.FindRecipeCommandById(recipeId));
        return VIEWS_IMAGE_UPLOAD_FORM;
    }

    @PostMapping(value = {"{recipeId}/image"})
    public String SaveImage(@PathVariable Long recipeId, @RequestParam("imagefile") MultipartFile file){
        imageService.saveImage(recipeId, file);
        return "redirect:/recipe/" + recipeId + "/";
    }

    @GetMapping(value = {"{recipeId}/recipeimage"})
    public void GetImageFromDB(@PathVariable Long recipeId, HttpServletResponse response) throws IOException {
        RecipeCommand command = recipeService.FindRecipeCommandById(recipeId);
        response.setContentType("image/jpeg");
        InputStream is = new ByteArrayInputStream(command.getImage());
        IOUtils.copy(is, response.getOutputStream());


    }


}
