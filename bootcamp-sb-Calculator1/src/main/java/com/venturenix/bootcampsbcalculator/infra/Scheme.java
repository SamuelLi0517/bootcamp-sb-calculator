package com.venturenix.bootcampsbcalculator.infra;

public enum Scheme {
  HTTPS, HTTP,;

  public String lowercaseName(){
    return this.name().toLowerCase();
  }
}
