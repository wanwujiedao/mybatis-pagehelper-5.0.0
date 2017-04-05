package com.zxdong.service;

import com.zxdong.mapper.UserMapper;
import com.zxdong.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zxdong on 2017/4/1.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public List<User> findByPage() {
        return userMapper.findByPage();
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userMapper.save(user);
    }
}
