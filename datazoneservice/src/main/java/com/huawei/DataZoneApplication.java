package com.huawei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DataZoneApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataZoneApplication.class,args);
    }
}
