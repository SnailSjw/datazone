package com.huawei.service.impl;

import com.huawei.service.IHelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements IHelloService {
    @Override
    public String hello() {
        return "hello world";
    }
}
