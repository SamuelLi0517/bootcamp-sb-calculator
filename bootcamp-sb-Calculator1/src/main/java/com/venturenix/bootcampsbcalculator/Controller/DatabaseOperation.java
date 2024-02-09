package com.venturenix.bootcampsbcalculator.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.venturenix.bootcampsbcalculator.model.Calculator;

public interface DatabaseOperation {

  @GetMapping(value = "/Calculator")
  @ResponseStatus(value = HttpStatus.OK)
  Calculator calculatorResult1(//
      @RequestParam(name = "x") String x, //
      @RequestParam(name = "y") String y, //
      @RequestParam(name = "operation") String operation) throws Exception;


  @GetMapping(value = "/Calculator/{x}/{y}/{operation}")
  Calculator calculatorResult2(@PathVariable String x, @PathVariable String y,
      @PathVariable String operation) throws Exception;

  @PostMapping(value = "/Calculate")
  Calculator calculatorResult3(@RequestBody Calculator calculator) throws Exception;


}
