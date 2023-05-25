package com.example.apiswagger.domain.staff.dto.recieve;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostStaffDto {
    @NotBlank(message = "Name can't be empty")
    private String name;
    @NotNull(message = "Avatar can't be null")
    private MultipartFile avatar;
}
