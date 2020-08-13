package com.huawei.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSON;
import com.huawei.dao.IUserDao;
import com.huawei.entiry.User;
import com.huawei.listener.UploadDataListener;
import com.huawei.service.IUserService;
import com.huawei.utils.EasyExcelUtil;
import com.huawei.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void exportAllUser(HttpServletResponse response)  throws IOException{
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("测试", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            List<User> list = userDao.selectAllUser();
            // 这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream(), User.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                    .doWrite(list);
        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = new HashMap<String, String>();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(JSON.toJSONString(map));
        }
    }
    @Override
    public void exportFile(){
        String fileName = FileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = null;
        List<User> list = userDao.selectAllUser();
        try {
            excelWriter = EasyExcel.write(fileName, User.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(list, writeSheet);
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }

    @Override
    public String upload(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(),User.class,new UploadDataListener(userDao)).sheet().doRead();
//            EasyExcelUtil.asyncReadModel(file.getInputStream(),new ExcelListener(),User.class,0,1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }


}
