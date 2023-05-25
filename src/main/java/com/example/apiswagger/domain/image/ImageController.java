package com.example.apiswagger.domain.image;

import com.example.apiswagger.domain.image.dto.recieve.AddImageDto;
import com.example.apiswagger.domain.image.dto.recieve.ChangeImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping("images/{id}")
    private ResponseEntity getImageById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(imageService.getImageById(id));
    }

    @PostMapping("image")
    private ResponseEntity addImage(@ModelAttribute AddImageDto imageDto) {
        return ResponseEntity.status(HttpStatus.OK).body(imageService.addImage(imageDto));
    }

    @PutMapping("images/{id}")
    private ResponseEntity updateImage(@ModelAttribute ChangeImageDto imageDto) {
        return ResponseEntity.status(HttpStatus.OK).body(imageService.changeImage(imageDto));
    }

    @DeleteMapping("images/{id}")
    private ResponseEntity deleteImage(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(imageService.deleteImage(id));
    }
}
