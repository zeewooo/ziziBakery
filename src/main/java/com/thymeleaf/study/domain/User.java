package com.thymeleaf.study.domain;

import lombok.Data;

@Data
public class User {
    int uid;
    String id;
    String pw;
    String userName;
    String email;
}
