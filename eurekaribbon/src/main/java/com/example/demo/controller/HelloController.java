package com.example.demo.controller;


import com.example.demo.service.HelloService;
import com.example.demo.service.HystrixCommandImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String sayHello(String name) {
        return helloService.sayHi(name);
    }

    @RequestMapping("/haha")
    public String sayHaHa(String name) {
        HystrixCommandImpl hystrixCommandImpl = new HystrixCommandImpl("service-hi",restTemplate,name);
        return hystrixCommandImpl.execute();
    }

}
