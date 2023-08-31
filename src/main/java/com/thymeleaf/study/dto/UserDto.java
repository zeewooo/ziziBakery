package com.thymeleaf.study.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
    private int uid;
    private String id;
    private String pw;
    private  String user_name;
    private String e_mail;

}
