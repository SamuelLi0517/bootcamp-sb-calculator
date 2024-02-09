package com.venturenix.bootcampsbcalculator.infra;

import lombok.Getter;

@Getter
public enum Syscode {
  OK("000000", "OK."), 

  // Runtime Exception
  Invalid_Input("9", "Invalid Input."),//
  GENERAL_EXCEPTION("999999", "General Exception.")
  ;

  private String code;
  private String message;

  private Syscode (String code, String message){
    this.code = code;
    this.message = message;
  }

 
}
