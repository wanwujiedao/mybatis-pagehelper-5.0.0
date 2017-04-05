package com.zxdong.mapper;

import com.zxdong.vo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zxdong on 2017/4/1.
 */
@Repository
public interface UserMapper {

    @Select("select * from User where username=#{username}")
    List<User> findByUserName(String username);

    @Select("select * from User")
    List<User> findByPage();

    @Select("select * from User where id=#{id}")
    User findById(Integer id);

    @Select("delete from user where id=#{id}")
    void deleteById(Integer id);

    /**
     * 保存数据,自增长，mysql自增长需要开启
     */
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("insert into User(username,password,age) values(#{username},#{password},${age})")
    void save(User user);

}
