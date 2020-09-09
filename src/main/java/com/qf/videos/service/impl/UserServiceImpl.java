package com.qf.videos.service.impl;

import com.qf.videos.mapper.UserMapper;
import com.qf.videos.pojo.User;
import com.qf.videos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(User user) {

        if(userMapper.selectUserByEmailAndPassword(user)!= null){
            return "success";
        }
        return "false";
    }
}
