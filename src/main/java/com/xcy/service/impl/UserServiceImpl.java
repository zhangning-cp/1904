package com.xcy.service.impl;

import com.xcy.mapper.UserMapper;
import com.xcy.pojo.User;
import com.xcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getAllUser() {

        return userMapper.selectUserAll();
    }
}
