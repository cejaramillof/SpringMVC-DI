package com.example.springbootweb.models.service;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary // indicate default class to inject
@Service("advancedService")
public class SecondService implements IFirstService {
    @Override
    public String operation() {
        return "return advanced operation";
    }
}



