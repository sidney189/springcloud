package com.example.demo.controller;

import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Value("${foo}")
    private String s;

    @RequestMapping("/hello")
    public String hello(String name){
        return helloService.sayHi(name)+s;
    }

    @RequestMapping("/haha")
    public String haha(String name){
        return helloService.sayHaHa(name);
    }
}
