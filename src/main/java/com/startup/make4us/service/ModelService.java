package com.startup.make4us.service;

import com.startup.make4us.dto.ModelDto;
import com.startup.make4us.entity.ModelEntity;
import com.startup.make4us.exception.ModelNameAlreadyExistException;
import com.startup.make4us.exception.ModelNotFoundException;
import com.startup.make4us.mapper.ModelMapper;
import com.startup.make4us.repository.ModelRepository;
import com.startup.make4us.request.ModelRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;

    public Page<ModelDto> getAll(Pageable pagination) {
        return modelRepository.findAll(pagination)
                .map(ModelMapper::toModelDto);
    }

    public ModelEntity getModelByName(String modelName) {
        return modelRepository.findByModelName(modelName)
                .orElseThrow(() -> new ModelNotFoundException("Model with name " + modelName + " not found"));
    }

    @Transactional
    public ModelDto createModel(ModelRequest request) {

        Optional<ModelEntity> modelName = modelRepository.findByModelName(request.getModelName());

        if (modelName.isPresent()) {
            throw new ModelNameAlreadyExistException("The model " + request.getModelName() + " already exists");
        }

        ModelEntity model = modelRepository.save(ModelMapper.toModel(request));

        return ModelMapper.toModelDto(model);
    }

    public ModelEntity updateEmail(ModelRequest request, Long Id) {
        Optional<ModelEntity> modelEntity = modelRepository.findById(Id);

        if (modelEntity.isEmpty()) {
            throw new ModelNotFoundException("Model id " + Id + " not found!");
        }
        ModelEntity editedModel = modelEntity.get();

        editedModel.setEmail(request.getEmail());

        return modelRepository.save(editedModel);
    }

    public ModelEntity updateAge(ModelRequest request, Long Id) {
        Optional<ModelEntity> modelEntity = modelRepository.findById(Id);

        if (modelEntity.isEmpty()) {
            throw new ModelNotFoundException("Model id " + Id + " not found!");
        }
        ModelEntity editedModel = modelEntity.get();

        editedModel.setAge(request.getAge());

        return modelRepository.save(editedModel);
    }

}
