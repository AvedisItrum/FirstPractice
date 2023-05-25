package com.example.apiswagger.domain.staff.dto.recieve;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

@Value
public class PostStaffDto {
    @NotBlank(message = "Name can't be empty")
     String name;
    @NotNull(message = "Avatar can't be null")
    MultipartFile avatar;
}
