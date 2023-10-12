package com.thymeleaf.study.mybatis.mappers;

import com.thymeleaf.study.domain.User;
import com.thymeleaf.study.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insertUsers(User user);
    int selectUsers(User user);

    User findUser(String id);
}


