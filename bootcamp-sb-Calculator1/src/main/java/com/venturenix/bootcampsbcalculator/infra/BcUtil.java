package com.venturenix.bootcampsbcalculator.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {
  
  public static String url(Scheme scheme, String domin, String endpoint){
    return UriComponentsBuilder.newInstance() //
    .scheme(scheme.lowercaseName())//
    .host(domin) //
    .path(endpoint) //
    .toUriString();
  }
}
