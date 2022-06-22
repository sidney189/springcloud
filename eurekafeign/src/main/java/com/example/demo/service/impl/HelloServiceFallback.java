package com.example.demo.service.impl;

import com.example.demo.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String sayHi(String name) {
        return "feign fallback";
    }
}
