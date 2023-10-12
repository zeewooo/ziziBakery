package com.thymeleaf.study.dao;

import com.thymeleaf.study.domain.User;
import com.thymeleaf.study.dto.UserDto;
import com.thymeleaf.study.mybatis.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    UserMapper userMapper;

    @Autowired
    public UserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public void writeJoin(User user) {
        userMapper.insertUsers(user);
    }

    public void writeLogin(User user){
        userMapper.selectUsers(user);
    }

    public User findUser(String id) {

        return userMapper.findUser(id);
    }

}
