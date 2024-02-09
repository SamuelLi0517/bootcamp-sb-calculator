package com.venturenix.bootcampsbcalculator.infra;

import lombok.Getter;

@Getter
public class InvalidInputException extends Exception{
  
  private String code;

  public InvalidInputException(Syscode syscode) {
    super(syscode.getMessage());
    this.code = syscode.getCode();
  }

 
}
