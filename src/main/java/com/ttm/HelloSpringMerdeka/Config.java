package com.ttm.HelloSpringMerdeka;

import com.ttm.HelloSpringMerdeka.Entity.Address;
import com.ttm.HelloSpringMerdeka.Entity.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Company.class)
public class Config {
    @Bean
    public Address getAddress(){
        return new Address("Jalan Ayu ", 3);
    }
}
