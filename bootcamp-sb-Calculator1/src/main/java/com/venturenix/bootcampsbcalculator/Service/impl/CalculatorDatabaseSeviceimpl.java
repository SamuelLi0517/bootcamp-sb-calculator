package com.venturenix.bootcampsbcalculator.Service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import com.venturenix.bootcampsbcalculator.Service.CalculatorDatabaseService;
import com.venturenix.bootcampsbcalculator.dto.CalculatorDto;
import com.venturenix.bootcampsbcalculator.model.Calculator;

@Service
public class CalculatorDatabaseSeviceimpl implements CalculatorDatabaseService {

  @Override
  public Calculator calculatorResult(String x, String y, String operation) throws Exception {
    CalculatorDto method = null;
    for(CalculatorDto m : CalculatorDto.values()){
      if(m.toString().equals(operation.toUpperCase())){
        method = m;
        break;
      }
    }
      BigDecimal x1 = BigDecimal.valueOf(Double.parseDouble(x));
    BigDecimal y1 = BigDecimal.valueOf(Double.parseDouble(y));
  
    String result = null;
    if(method != null) {
      switch (method) {
        case ADD -> result = x1.add(y1).toString();

        case SUB -> result = x1.subtract(y1).toString();

        case MUL -> result = x1.multiply(y1).toString();

        case DIV -> result = x1.divide(y1, 5, RoundingMode.HALF_UP).toString();
      
        default -> throw new IllegalArgumentException();
      }
    } else 
    throw new IllegalArgumentException();

    return new Calculator(x, y, operation.toUpperCase(), result);
    }
  }
  
  
 
