package com.thymeleaf.study.mybatis.mappers;

import com.thymeleaf.study.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insertUsers(UserDto userDto);
    int selectUsers(UserDto userDto);
}


