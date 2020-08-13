package com.huawei.service;

import com.huawei.entiry.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IUserService {

    int insert(User user);

    int deleteById(int id);

    int updateUserById(User user);

    List<User> selectAllUser();

    User selectById(int id);

    void exportAllUser(HttpServletResponse response);
}
