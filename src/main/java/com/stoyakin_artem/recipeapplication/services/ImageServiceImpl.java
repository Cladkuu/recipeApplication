package com.stoyakin_artem.recipeapplication.services;

import com.stoyakin_artem.recipeapplication.Model.Recipe;
import com.stoyakin_artem.recipeapplication.converters.RecipesConverter;
import com.stoyakin_artem.recipeapplication.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {


    private final RecipeService recipeService;
    private final RecipeRepository recipeRepository;

    @Override
    public void saveImage(Long recipeID, MultipartFile file) {
        log.debug("saving image to Recipe: " + recipeID);

        try {
            Recipe recipe = recipeService.findById(recipeID);

            byte[] byteObject = new byte[file.getBytes().length];


            int i=0;
            for(byte b : file.getBytes()){
                byteObject[i++] = b;
            }

            recipe.setImage(byteObject);
            recipeRepository.save(recipe);

        }
        catch (Exception e){
            //todo handle better
            log.error("Error occurred", e);

            e.printStackTrace();
        }




    }
}
