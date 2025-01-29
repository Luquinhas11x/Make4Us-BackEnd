package com.startup.make4us.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ModelDto {
    private Long id;
    private String modelName;
    private String profilePhotoUrl;
    private Integer age;
    private String email;
    private Integer rating;
}
