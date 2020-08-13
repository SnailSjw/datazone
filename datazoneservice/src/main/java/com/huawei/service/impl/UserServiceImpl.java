package com.huawei.service.impl;

import com.huawei.dao.IUserDao;
import com.huawei.entiry.User;
import com.huawei.service.IUserService;
import com.huawei.utils.EasyExcelUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    IUserDao userDao;
    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int deleteById(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public int updateUserById(User user) {
        return userDao.updateUserById(user);
    }

    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public User selectById(int id) {
        return userDao.selectById(id);
    }

    @Override
    public void exportAllUser(HttpServletResponse response) {
        try {
            List<User> data = userDao.selectAllUser();
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("UTF-8");
            String filePath = "G:\\IdeaProjects\\datazone\\";
            String fileName = URLEncoder.encode("User测试","UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            EasyExcelUtil.writeWithSheetsWeb(response,fileName)
                    .writeModel(User.class,data,"sheet0")
                    .finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
