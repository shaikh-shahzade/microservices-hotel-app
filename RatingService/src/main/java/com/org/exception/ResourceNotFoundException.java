package com.org.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resource , String value , String id)
    {
        super(String.format("ResourceNotFound- %s is not found for %s: %s",resource,value,id));
    }
}
