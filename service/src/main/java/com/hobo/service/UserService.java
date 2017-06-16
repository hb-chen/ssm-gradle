package com.hobo.service;

import com.hobo.dao.entity.User;
import com.hobo.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Steven on 16/12/7.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User findByUsername(String username) {
        return null;
    }

    public String encryptPassword(String plainPassword, String salt) {
        return null;
    }

    public String encryptPassword(User user) {
        return null;
    }
}
