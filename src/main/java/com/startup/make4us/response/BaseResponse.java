package com.startup.make4us.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse<T> {
    private Integer httpCode;
    private String message;
    private T response;
}
