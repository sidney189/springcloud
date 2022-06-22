package com.example.demo.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

public class HystrixCommandImpl extends HystrixCommand<String> {
    private RestTemplate restTemplate;
    private String name;
    public HystrixCommandImpl(String groupKey,RestTemplate restTemplate,String name){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey)));
        this.restTemplate = restTemplate;
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return restTemplate.getForEntity("http://service-hi/haha?name=" + this.name, String.class).getBody();
    }

    @Override
    protected String getFallback() {
        return "getFallback"+this.name;
    }
}
