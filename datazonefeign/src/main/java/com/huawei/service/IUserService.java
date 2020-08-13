package com.huawei.service;

import com.huawei.entiry.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@FeignClient("datazone")
public interface IUserService {
    @PostMapping("/user/insert")
    int insert(@RequestBody User user);

    @GetMapping("/user/delete/{id}")
    int deleteById(@PathVariable("id") Integer id) ;

    @PostMapping("/user/update")
    int updateUserById(@RequestBody User user) ;

    @GetMapping("/user/allUser")
    List<User> selectAllUser() ;

    @GetMapping("/user/select/{id}")
    User selectById(@PathVariable("id")Integer id) ;

    @GetMapping("/user/export")
    ResponseEntity<String> exportAllUser(HttpServletResponse response);
}
