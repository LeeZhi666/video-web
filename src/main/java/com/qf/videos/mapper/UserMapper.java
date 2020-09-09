package com.qf.videos.mapper;

import com.qf.videos.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User selectUserByEmailAndPassword(User user);
}
