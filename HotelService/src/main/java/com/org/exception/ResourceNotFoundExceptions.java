package com.org.exception;

public class ResourceNotFoundExceptions extends RuntimeException{
   public ResourceNotFoundExceptions(String resource , String value , Long id)
    {
        super(String.format("Resource: %s is not found %s: %s",resource,value,id));
    }
}
