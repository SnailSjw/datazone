package com.huawei.controller;

import com.huawei.service.IHelloService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    IHelloService IHelloService;

    @GetMapping("/hello")
    @ApiOperation(value="测试整合", notes="第一个测试接口Hello",produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "success")})
    public String Hello(){
        return IHelloService.hello();
    }

}
