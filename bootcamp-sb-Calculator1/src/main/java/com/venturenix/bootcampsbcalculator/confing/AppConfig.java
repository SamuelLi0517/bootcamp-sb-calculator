package com.venturenix.bootcampsbcalculator.confing;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Configurable
public class AppConfig {
  
   @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
