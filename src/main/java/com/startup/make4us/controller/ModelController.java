package com.startup.make4us.controller;

import com.startup.make4us.dto.ModelDto;
import com.startup.make4us.mapper.ModelMapper;
import com.startup.make4us.request.ModelRequest;
import com.startup.make4us.response.BaseResponse;
import com.startup.make4us.response.BaseResponseError;
import com.startup.make4us.service.ModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Model Controller")
@RestController
@AllArgsConstructor
@RequestMapping("/model")
public class ModelController {
    private final ModelService modelService;

    @ApiOperation(
            value = "Get model by name",
            response = ModelDto.class,
            produces = "application/json"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully obtain model"),
            @ApiResponse(code = 400, message = "Bad request", response = BaseResponseError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = BaseResponseError.class),
            @ApiResponse(code = 404, message = "Model not found", response = BaseResponseError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = BaseResponseError.class),
    })
    @GetMapping("/{id}")
    public BaseResponse<ModelDto> getModelByName(@PathVariable String modelName) {
        return BaseResponse.<ModelDto>builder()
                .httpCode(200)
                .message("OK")
                .response(ModelMapper.toModelDto(modelService.getModelByName(modelName)))
                .build();
    }

    @ApiOperation(
            value = "Get model list",
            response = ModelDto.class,
            produces = "application/json"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully obtain model list"),
            @ApiResponse(code = 401, message = "Unauthorized", response = BaseResponseError.class),
            @ApiResponse(code = 400, message = "Bad request", response = BaseResponseError.class),
            @ApiResponse(code = 404, message = "Model not found", response = BaseResponseError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = BaseResponseError.class),
    })
    @GetMapping()
    public BaseResponse<Page<ModelDto>> getModel(@PageableDefault(size = 10, sort = {"rating"}) Pageable pagination){
        return BaseResponse.<Page<ModelDto>>builder()
                .httpCode(200)
                .message("OK")
                .response(modelService.getAll(pagination))
                .build();
    }

    @ApiOperation(
            value = "Post a new model",
            response = ModelDto.class,
            produces = "application/json",
            consumes = "application/json"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Model successfully posted"),
            @ApiResponse(code = 400, message = "Bad request", response = BaseResponseError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = BaseResponseError.class),
            @ApiResponse(code = 404, message = "Model not found", response = BaseResponseError.class),
            @ApiResponse(code = 409, message = "Model already exists", response = BaseResponseError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = BaseResponseError.class),
    })
    @PostMapping()
    public BaseResponse<ModelDto> addModel(@RequestBody ModelRequest request){
        return BaseResponse.<ModelDto>builder()
                .httpCode(201)
                .message("CREATED")
                .response(modelService.createModel(request))
                .build();

    }

    @ApiOperation(
            value = "Update model email",
            response = ModelDto.class,
            produces = "application/json",
            consumes = "application/json"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully edited model email"),
            @ApiResponse(code = 400, message = "Bad request", response = BaseResponseError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = BaseResponseError.class),
            @ApiResponse(code = 404, message = "Model not found", response = BaseResponseError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = BaseResponseError.class),
    })
    @PutMapping("/email/{id}")
    public BaseResponse<ModelDto> uptadeModelEmail(@RequestBody ModelRequest request, @PathVariable Long id){
        return BaseResponse.<ModelDto>builder()
                .httpCode(204)
                .message("NO CONTENT")
                .response(ModelMapper.toModelDto(modelService.updateEmail(request, id)))
                .build();
    }

    @ApiOperation(
            value = "Update model age",
            response = ModelDto.class,
            produces = "application/json",
            consumes = "application/json"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully edited model age"),
            @ApiResponse(code = 400, message = "Bad request", response = BaseResponseError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = BaseResponseError.class),
            @ApiResponse(code = 404, message = "Model not found", response = BaseResponseError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = BaseResponseError.class),
    })
    @PutMapping("/age/{id}")
    public BaseResponse<ModelDto> uptadeModelAge(@RequestBody ModelRequest request, @PathVariable Long id){
        return BaseResponse.<ModelDto>builder()
                .httpCode(204)
                .message("NO CONTENT")
                .response(ModelMapper.toModelDto(modelService.updateAge(request, id)))
                .build();
    }
}
