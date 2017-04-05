package com.zxdong.service;

import com.zxdong.vo.User;

import java.util.List;

/**
 * Created by zxdong on 2017/4/1.
 */
public interface IUserService {
    List<User> findByUserName(String username);
    List<User> findByPage();

    User findById(Integer id);

    void deleteById(Integer id);

    void save(User user);

}
