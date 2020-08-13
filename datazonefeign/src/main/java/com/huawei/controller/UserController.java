package com.huawei.controller;

import com.huawei.entiry.User;
import com.huawei.service.IUserService;
import feign.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private IUserService userService;
    @PostMapping("/insert")
    @ResponseBody
    public int insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public int deleteById(@PathVariable("id") Integer id) {
        return userService.deleteById(id);
    }

    @PostMapping("/update")
    @ResponseBody
    public int updateUserById(User user) {
        return userService.updateUserById(user);
    }

    @GetMapping("/allUser")
    @ResponseBody
    public List<User> selectAllUser() {
        return userService.selectAllUser();
    }

    @GetMapping("/select/{id}")
    @ResponseBody
    public User selectById(@PathVariable("id") Integer id) {
        return userService.selectById(id);
    }

    @GetMapping("/export")
    @ResponseBody
    public ResponseEntity<String> exportAllUser(HttpServletResponse response){
        ResponseEntity<byte[]> result = null;
        return userService.exportAllUser(response);
        /*InputStream inputStream = null;
        try {
            // feign文件下载
            //Response response = fileTestClient.download();

            Response.Body body = response.body();
            inputStream = body.asInputStream();
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            HttpHeaders heads = new HttpHeaders();
            heads.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=lr.xls");
            heads.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

            result = new ResponseEntity<byte[]>(b, heads, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
        */

        //userService.exportAllUser(response);
    }
}
