package com.example.demo.service.impl;

import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloServcieImpl implements HelloService {
    @Value("${server.port}")
    private String port;

    @Override
    public String sayHi(String name) {
        return "hi,i am provider" + port;
    }
}
