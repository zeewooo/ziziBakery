package com.thymeleaf.study.service;

import com.thymeleaf.study.dao.UserDao;
import com.thymeleaf.study.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void writeJoin(UserDto userDto) {
        userDao.writeJoin(userDto);
    }

    public void writeLogin(UserDto userDto){
        userDao.writeLogin(userDto);
    }
}
