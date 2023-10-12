package com.thymeleaf.study.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class LoginResponseDto {

    private int uid;
    private String id;
    private String user_name;


}
