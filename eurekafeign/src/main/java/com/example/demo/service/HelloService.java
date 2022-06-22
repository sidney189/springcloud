package com.example.demo.service;

import com.example.demo.service.impl.HelloServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-hi",fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    String sayHi(String name);
}
