package com.startup.make4us.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelRequest {
    private String modelName;
    private String profilePhotoUrl;
    private int age;
    private String email;
}
