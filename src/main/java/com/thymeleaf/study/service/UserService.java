package com.thymeleaf.study.service;

import com.thymeleaf.study.dao.UserDao;
import com.thymeleaf.study.domain.User;
import com.thymeleaf.study.dto.LoginDto;
import com.thymeleaf.study.dto.LoginResponseDto;
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
        User user = new User();
        user.setId(userDto.getId());
        user.setPw(userDto.getPw());
        user.setEmail(userDto.getE_mail());
        user.setUserName(userDto.getUser_name());

        userDao.writeJoin(user);
    }


    public void writeLogin(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setPw(userDto.getPw());
        userDao.writeLogin(user);
    }


    public LoginResponseDto findUser(LoginDto loginDto) {

        User user = userDao.findUser(loginDto.getId());

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setUid(user.getUid());
        loginResponseDto.setId(user.getId());


        if(user.getPw().equals(loginDto.getPw())){
            return loginResponseDto;
        }

        return null;
    }


}
