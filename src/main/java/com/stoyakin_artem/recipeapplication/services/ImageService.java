package com.stoyakin_artem.recipeapplication.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void saveImage(Long recipeID, MultipartFile file);
}
