package com.startup.make4us.mapper;

import com.startup.make4us.dto.ModelDto;
import com.startup.make4us.entity.ModelEntity;
import com.startup.make4us.request.ModelRequest;

public class ModelMapper {

    public ModelMapper(){}

    public static ModelDto toModelDto(ModelEntity model){
        return ModelDto.builder()
                .modelName(model.getModelName())
                .age(model.getAge())
                .email(model.getEmail())
                .profilePhotoUrl(model.getProfilePhotoUrl())
                .rating(model.getRating())
                .build();
    }

    public static ModelEntity toModel(ModelRequest request){
        return ModelEntity.builder()
                .modelName(request.getModelName())
                .age(request.getAge())
                .email(request.getEmail())
                .profilePhotoUrl(request.getProfilePhotoUrl())
                .build();
    }

}
