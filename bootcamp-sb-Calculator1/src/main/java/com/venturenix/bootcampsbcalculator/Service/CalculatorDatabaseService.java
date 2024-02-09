package com.venturenix.bootcampsbcalculator.Service;

import com.venturenix.bootcampsbcalculator.model.Calculator;

public interface CalculatorDatabaseService {

  Calculator calculatorResult(String x, String y, String operation) throws Exception;
}
