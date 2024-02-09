package com.venturenix.bootcampsbcalculator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.venturenix.bootcampsbcalculator.Controller.impl.CalculatorDatabaseController;
import com.venturenix.bootcampsbcalculator.Service.impl.CalculatorDatabaseSeviceimpl;
import com.venturenix.bootcampsbcalculator.model.Calculator;

@WebMvcTest(CalculatorDatabaseController.class)
public class CalculatrorControllerTests {
  
   @Autowired
  private MockMvc mockMvc;

 @MockBean
  private CalculatorDatabaseSeviceimpl calculatorDatabaseSeviceimpl;

  @Test
  void testCalculatorAdd() throws Exception {
    Calculator mockedReturnCompute = new Calculator("10", "10", "ADD", "20.0");

    Mockito.when(calculatorDatabaseSeviceimpl.calculatorResult("10", "10", "add")).thenReturn(mockedReturnCompute);

    mockMvc.perform(get("/api/v1/Calculator/{x}/{y}/{operation}", "10", "10", "add"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.x").value("10"))
        .andExpect(jsonPath("$.y").value("10"))
        .andExpect(jsonPath("$.operation").value("ADD"))
        .andExpect(jsonPath("$.result").value("20.0"))
        .andDo(print());
  }

  @Test
  void testCalculatorSubtract() throws Exception {
    Calculator mockedReturnCompute = new Calculator("10", "10", "SUB", "0.0");

    Mockito.when(calculatorDatabaseSeviceimpl.calculatorResult("10", "10", "sub")).thenReturn(mockedReturnCompute);

    mockMvc.perform(get("/api/v1/Calculator?x=10&y=10&operation=sub"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.x").value("10"))
        .andExpect(jsonPath("$.y").value("10"))
        .andExpect(jsonPath("$.operation").value("SUB"))
        .andExpect(jsonPath("$.result").value("0.0"))
        .andDo(print());
  }

  @Test
  void testCalculatorMultiply() throws Exception {
    Calculator mockedReturnCompute = new Calculator("10", "10", "MUL", "100.00");
    Calculator mockedRequest = new Calculator("10", "10", "mul", null);

    String contentString = new ObjectMapper().writeValueAsString(mockedRequest);

    Mockito.when(calculatorDatabaseSeviceimpl.calculatorResult("10", "10", "mul")).thenReturn(mockedReturnCompute);

    mockMvc.perform(post("/api/v1/Calculate")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(contentString))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.x").value("10"))
        .andExpect(jsonPath("$.y").value("10"))
        .andExpect(jsonPath("$.operation").value("MUL"))
        .andExpect(jsonPath("$.result").value("100.00"))
        .andDo(print());
  }

  @Test
  void testCalculatorDivide() throws Exception {
    Calculator mockedReturnCompute = new Calculator("10", "10", "DIV", "1.00000");
    Calculator mockedRequest = new Calculator("10", "10", "div", null);

    String contentString = new ObjectMapper().writeValueAsString(mockedRequest);

    Mockito.when(calculatorDatabaseSeviceimpl.calculatorResult("10", "10", "div")).thenReturn(mockedReturnCompute);

    mockMvc.perform(post("/api/v1/Calculate")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(contentString))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.x").value("10"))
        .andExpect(jsonPath("$.y").value("10"))
        .andExpect(jsonPath("$.operation").value("DIV"))
        .andExpect(jsonPath("$.result").value("1.00000"))
        .andDo(print());
  }




}
