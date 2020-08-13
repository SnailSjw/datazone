package com.huawei.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("datazone")
public interface IHelloService {

    @GetMapping("/hello")
    String hello();
}
