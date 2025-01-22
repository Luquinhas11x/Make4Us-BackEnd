package com.startup.make4us.controller;

import com.startup.make4us.dto.ModelDto;
import com.startup.make4us.mapper.ModelMapper;
import com.startup.make4us.request.ModelRequest;
import com.startup.make4us.response.BaseResponse;
import com.startup.make4us.service.ModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public BaseResponse<Page<ModelDto>> getModel(@PageableDefault(size = 10, sort = {"rating"}) Pageable pagination){
        return BaseResponse.<Page<ModelDto>>builder()
                .httpCode(200)
                .message("OK")
                .response(modelService.getAll(pagination))
                .build();
    }

    @PostMapping()
    public BaseResponse<ModelDto> addModel(@RequestBody ModelRequest request){
        return BaseResponse.<ModelDto>builder()
                .httpCode(201)
                .message("CREATED")
                .response(modelService.createModel(request))
                .build();

    }


    @PutMapping("/email/{id}")
    public BaseResponse<ModelDto> uptadeModelEmail(@RequestBody ModelRequest request, @PathVariable Long id){
        return BaseResponse.<ModelDto>builder()
                .httpCode(204)
                .message("NO CONTENT")
                .response(ModelMapper.toModelDto(modelService.updateEmail(request, id)))
                .build();
    }

    @PutMapping("/age/{id}")
    public BaseResponse<ModelDto> uptadeModelAge(@RequestBody ModelRequest request, @PathVariable Long id){
        return BaseResponse.<ModelDto>builder()
                .httpCode(204)
                .message("NO CONTENT")
                .response(ModelMapper.toModelDto(modelService.updateAge(request, id)))
                .build();
    }
}
