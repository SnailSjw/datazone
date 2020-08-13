package com.huawei.dao;

import com.huawei.entiry.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IUserDao {

    @Insert("insert into User (id, name, age, birthday, introduce) values (#{id},#{name},#{age},#{birthday},#{introduce})")
    int insert(User user);
    @Delete("delete from User WHERE ID =#{id}")
    int deleteById(int id);
    @Update("update User set name=#{name},age=#{age},birthday=#{birthday},introduce=#{introduce} where id =#{id}")
    int updateUserById(User user);
    @Select("select id, name, age, birthday, introduce from User")
    List<User> selectAllUser();
    @Select("select id, name, age, birthday, introduce from User where id=#{id}")
    User selectById(int id);
}
