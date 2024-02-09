package com.venturenix.bootcampsbcalculator.infra;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiResponse <T>{
  
  private String code;
  private String message;

}
