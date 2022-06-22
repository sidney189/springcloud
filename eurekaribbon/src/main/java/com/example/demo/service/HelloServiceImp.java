package com.example.demo.service;

import com.example.demo.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImp implements HelloService {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private OAuth2RestTemplate oauth2RestTemplate;

    @Override
    public String sayHi(String name) {
        String result = oauth2RestTemplate.getForEntity("http://service-hi/hello", String.class,name).getBody();
        return result;
    }

//    @Override
//    public String sayHaHa(String name) {
//        String result = oauth2RestTemplate.getForEntity("http://localhost:9001/haha?name=" + name, String.class).getBody();
//        return result;
//    }

//    public String fallBackDemo(String name){
//        return "fallbackdemo";
//    }
}
