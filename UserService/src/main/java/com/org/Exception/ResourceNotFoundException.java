package com.org.Exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resource , String value , Long id )
    {
        super(String.format("Resource: %s is not found for %s: %l" , resource , value , id));
    }

}
