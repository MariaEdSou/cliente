package com.api.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
@RequiredArgsConstructor
@Getter
public class BusinessException extends RuntimeException{

    private final HttpStatusCode statusCode;
    private final String message;

}
