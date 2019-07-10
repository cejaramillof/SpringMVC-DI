package com.example.springbootweb;

import com.example.springbootweb.models.service.FirstService;
import com.example.springbootweb.models.service.IFirstService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// this class can be used by spring like a beans repository
// is more used when is external class like from api, frameworks
// @Configuration
public class AppConfig {

    @Bean("name")
    public IFirstService firstService(){
        return new FirstService();
    }
}
