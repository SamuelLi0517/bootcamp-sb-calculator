package com.venturenix.bootcampsbcalculator.Controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.venturenix.bootcampsbcalculator.Controller.DatabaseOperation;
import com.venturenix.bootcampsbcalculator.Service.impl.CalculatorDatabaseSeviceimpl;
import com.venturenix.bootcampsbcalculator.model.Calculator;

@RestController
@RequestMapping(value = "/api/v1")
public class CalculatorDatabaseController implements DatabaseOperation {

  @Autowired
  private CalculatorDatabaseSeviceimpl calculatorDatabaseServiceimpl;

  @Override
  public  Calculator calculatorResult1(String x, String y, String operation) throws Exception {
    return calculatorDatabaseServiceimpl.calculatorResult(x, y, operation);
  }

  @Override
  public Calculator calculatorResult2(String x, String y, String operation)
      throws Exception {
        return calculatorDatabaseServiceimpl.calculatorResult(x, y, operation);
  }

  @Override
  public Calculator calculatorResult3(Calculator calculator) throws Exception {
    return calculatorDatabaseServiceimpl.calculatorResult(calculator.getX(), calculator.getY(), calculator.getOperation());
  }

 
}
