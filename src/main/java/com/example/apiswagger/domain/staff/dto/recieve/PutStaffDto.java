package com.example.apiswagger.domain.staff.dto.recieve;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PutStaffDto {

    @NotNull
    private Long id;

    @NotBlank(message = "Name can't be empty")
    private String name;

    @Nullable
    private MultipartFile optAvatar;
}
