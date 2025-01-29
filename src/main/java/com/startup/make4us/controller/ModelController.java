package com.startup.make4us.controller;

import com.startup.make4us.dto.ModelDto;
import com.startup.make4us.mapper.ModelMapper;
import com.startup.make4us.request.ModelRequest;
import com.startup.make4us.request.ModelRequestAge;
import com.startup.make4us.request.ModelRequestEmail;
import com.startup.make4us.response.BaseResponse;
import com.startup.make4us.service.ModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/model")
public class ModelController {
    private final ModelService modelService;

    @Operation(summary = "Get model by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully obtain model"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Model not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
    })
    @GetMapping("/{modelName}")
    public BaseResponse<ModelDto> getModelByName(@PathVariable String modelName) {
        return BaseResponse.<ModelDto>builder()
                .httpCode(200)
                .message("OK")
                .response(ModelMapper.toModelDto(modelService.getModelByName(modelName)))
                .build();
    }


    @GetMapping()
    @Operation(summary = "Get all models")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully obtain models"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Models not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
    })
    public BaseResponse<Page<ModelDto>> getModel(){
        Pageable pagination = PageRequest.of(0, 10, Sort.by("rating").descending());

        return BaseResponse.<Page<ModelDto>>builder()
                .httpCode(200)
                .message("OK")
                .response(modelService.getAll(pagination))
                .build();
    }

    @Operation(summary = "Create model")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully created model"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Model not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
    })
    @PostMapping()
    public BaseResponse<ModelDto> addModel(@RequestBody ModelRequest request){
        return BaseResponse.<ModelDto>builder()
                .httpCode(201)
                .message("CREATED")
                .response(modelService.createModel(request))
                .build();

    }

    @Operation(summary = "Update model email by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully updated model email"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Model not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
    })
    @PutMapping("/email/{id}")
    public BaseResponse<ModelDto> uptadeModelEmail(@RequestBody ModelRequestEmail request, @PathVariable Long id){
        return BaseResponse.<ModelDto>builder()
                .httpCode(200)
                .message("OK")
                .response(ModelMapper.toModelDto(modelService.updateEmail(request, id)))
                .build();
    }

    @Operation(summary = "Update model age by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully updated model age"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Model not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
    })
    @PutMapping("/age/{id}")
    public BaseResponse<ModelDto> uptadeModelAge(@RequestBody ModelRequestAge request, @PathVariable Long id){
        return BaseResponse.<ModelDto>builder()
                .httpCode(200)
                .message("OK")
                .response(ModelMapper.toModelDto(modelService.updateAge(request, id)))
                .build();
    }

    @Operation(summary = "Delete model by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully deleted model"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Model not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
    })
    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteModel(@PathVariable Long id) {
        modelService.deleteById(id);

        return BaseResponse.<Void>builder()
                        .httpCode(200)
                        .message("OK")
                        .build();

    }
}
