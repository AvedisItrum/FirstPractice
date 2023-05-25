package com.example.apiswagger.domain.image.dto.recieve;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeImageDto {

    @NotNull
    private Long id;
    @NotNull(message = "File can't be null")
    private MultipartFile file;

}
