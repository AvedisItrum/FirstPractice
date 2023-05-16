package com.example.apiswagger.domain.staff.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateStaffInfoDto {
    @NotBlank(message = "Name can't be empty")
    private String name;

    @Nullable
    private byte[] optAvatar;
}
