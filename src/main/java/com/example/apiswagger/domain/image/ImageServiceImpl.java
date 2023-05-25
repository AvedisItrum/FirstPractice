package com.example.apiswagger.domain.image;

import com.example.apiswagger.domain.image.dto.recieve.AddImageDto;
import com.example.apiswagger.domain.image.dto.recieve.ChangeImageDto;
import com.example.apiswagger.domain.web.dto.CustomExceptions;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ImageIO imageIO;

    @Override
    public Image addImage(@Valid AddImageDto image){

        return imageRepository.save(imageIO.addImage(image));
    }


    @Override
    public Image getImageById(Long id) {
        return imageRepository
                .findById(id)
                .orElseThrow(CustomExceptions.IdNotFound(Image.class, id));
    }

    @Override
    public Image changeImage(ChangeImageDto image){
        return imageRepository.save(
                imageIO.changeImage(
                        imageRepository.findById(image.getId())
                                .orElseThrow(CustomExceptions.IdNotFound(Image.class, image.getId())),
                        image)
        );
    }

    @Override
    public Long deleteImage(Long id) {
        Image image = imageRepository
                .findById(id)
                .orElseThrow(CustomExceptions.IdNotFound(Image.class, id));
        imageRepository.delete(image);
        imageIO.deleteImage(image);
        return id;
    }

    @Override
    public Set<Image> getImagesByIds(Set<Long> posters) {
        Set<Image> images = imageRepository.findAllByIdIn(posters);
        if (images.size() == posters.size())
            return images;

        Iterator<Long> iterator = images.stream().map(Image::getId).iterator();

        while (iterator.hasNext())
            posters.remove(iterator.next());

        throw CustomExceptions.IdsNotFound(Image.class,posters).get();
    }
}
