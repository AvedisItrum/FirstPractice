package com.example.apiswagger.domain.image;

import com.example.apiswagger.domain.image.dto.recieve.AddImageDto;
import com.example.apiswagger.domain.image.dto.recieve.ChangeImageDto;

import java.util.Set;

public interface ImageService {
    Image addImage(AddImageDto image);
    Image getImageById(Long id);
    Image changeImage(ChangeImageDto image);
    Long deleteImage(Long id);

    Set<Image> getImagesByIds(Set<Long> posters);
}
