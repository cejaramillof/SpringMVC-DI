package com.example.springbootweb.models.service;

import org.springframework.stereotype.Service;

@Service("basicFirstService")
public class FirstService implements IFirstService {

    @Override
    public String operation() {
        return "return operation";
    }
}
