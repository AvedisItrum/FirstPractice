package com.example.apiswagger.domain.image;

import com.example.apiswagger.domain.image.dto.recieve.AddImageDto;
import com.example.apiswagger.domain.image.dto.recieve.ChangeImageDto;
import com.example.apiswagger.domain.web.dto.CustomExceptions;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;


@Service
public class ImageIO {
    String path = "images/";

    Image addImage(AddImageDto newImage) {

        String newName = DigestUtils.md5Hex(newImage.getFile().getOriginalFilename() + LocalDateTime.now());
        File file = new File(path + newName);

        try {
            if (!file.createNewFile())
                throw CustomExceptions.FileAlreadyExists(newImage.getFile().getOriginalFilename()).get();
            newImage.getFile().transferTo(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Image(0L, "EmptyForTest", file.getPath());
    }

    Image changeImage(Image image, ChangeImageDto newImage) {
        String newName = DigestUtils.md5Hex(newImage.getFile().getOriginalFilename() + LocalDateTime.now());

        File file = new File(image.getPath());

        try {
            newImage.getFile().transferTo(file.toPath());
            if (!file.exists())
                throw CustomExceptions.FileNotFound(file.getName()).get();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        file.renameTo(new File(path + newName));

        return new Image(image.getId(), "EmptyForTest", path + newName);
    }

    void deleteImage(Image image) {
        new File(image.getPath()).delete();
    }
}
