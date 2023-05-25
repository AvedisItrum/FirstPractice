package com.example.apiswagger.domain.staff.dto.recieve;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

@Value
public class PutStaffDto {

    @NotNull
    Long id;

    @NotBlank(message = "Name can't be empty")
    String name;

    @Nullable
    MultipartFile optAvatar;
}
