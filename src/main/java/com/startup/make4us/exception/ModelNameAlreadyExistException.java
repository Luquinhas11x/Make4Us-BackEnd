package com.startup.make4us.exception;

public class ModelNameAlreadyExistException extends EntityNotFoundException{
    public ModelNameAlreadyExistException(String baseError) {
        super(baseError);
    }
}
