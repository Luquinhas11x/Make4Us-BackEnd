package com.startup.make4us.exception;

public class ModelNotFoundException extends EntityNotFoundException{
    public ModelNotFoundException(String baseError) {
        super(baseError);
    }
}
