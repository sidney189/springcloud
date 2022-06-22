package com.example.demo.service.impl;

import com.example.demo.dao.HelloDao;
import com.example.demo.service.HelloService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloDao helloDao;
    @Value("${server.port}")
    private String port;

    @Override
    public String sayHi(String name) {
        Integer num = helloDao.getCount();
        return "hi,i am provider" + port + "count:"+num;
    }

    @Override
    public String sayHaHa(String name) {
        return "haha,i am provider" + port;
    }
}
