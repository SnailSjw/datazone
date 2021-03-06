package com.huawei.controller;

import com.huawei.entiry.User;
import com.huawei.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/insert")
    public int insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @GetMapping("/delete/{id}")
    public int deleteById(@PathVariable("id") Integer id) {
        return userService.deleteById(id);
    }

    @PostMapping("/update")
    public int updateUserById(User user) {
        return userService.updateUserById(user);
    }

    @GetMapping("/allUser")
    public List<User> selectAllUser() {
        return userService.selectAllUser();
    }

    @GetMapping("/select/{id}")
    public User selectById(@PathVariable("id") Integer id) {
        return userService.selectById(id);
    }

    @GetMapping("/export")
    @ResponseBody
    public void exportAllUser(HttpServletResponse response){
        try {
            userService.exportAllUser(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/exportFile")
    @ResponseBody
    public void exportFile(){
        userService.exportFile();
    }

    @PostMapping("/upload")
    public String upload(@RequestPart("file") MultipartFile file) {
        return userService.upload(file);
    }
}
