package com.startup.make4us.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MakeupArtistDto {
    private String name;
    private String profilePhotoUrl;
    private Integer age;
    private String email;
}
