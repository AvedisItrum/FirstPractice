package com.example.apiswagger.domain.image.dto.recieve;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
public class AddImageDto {
    @NotNull(message = "File can't be null")
    private MultipartFile file;
}
