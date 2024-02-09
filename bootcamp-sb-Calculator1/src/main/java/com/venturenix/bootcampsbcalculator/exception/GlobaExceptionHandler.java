package com.venturenix.bootcampsbcalculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.venturenix.bootcampsbcalculator.infra.ApiResponse;
import com.venturenix.bootcampsbcalculator.infra.InvalidInputException;
import com.venturenix.bootcampsbcalculator.infra.Syscode;

@RestControllerAdvice
public class GlobaExceptionHandler {

  @ExceptionHandler(InvalidInputException.class) 
  @ResponseStatus(value = HttpStatus.OK) 
  public ApiResponse<Void> invalidInputExceptionHandler(InvalidInputException e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.Invalid_Input.getCode()) //
        .message(Syscode.Invalid_Input.getMessage()) //
        .build();
  }

  @ExceptionHandler(NumberFormatException.class) 
  @ResponseStatus(value = HttpStatus.OK) 
  public ApiResponse<Void> NumberFormatExceptionHandler(NumberFormatException e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.Invalid_Input.getCode()) //
        .message(Syscode.Invalid_Input.getMessage()) //
        .build();
  }


  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResponse<Void> illegalArgumentExceptionHandler(IllegalArgumentException e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.Invalid_Input.getCode()) //
        .message(Syscode.Invalid_Input.getMessage()) //
        .build();
  }
  
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResponse<Void> npeExceptionHandler(Exception e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.GENERAL_EXCEPTION.getCode()) //
        .message(Syscode.GENERAL_EXCEPTION.getMessage()) //
        .build();
  }
  
  
}
