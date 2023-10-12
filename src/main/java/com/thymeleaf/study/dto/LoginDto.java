package com.thymeleaf.study.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class LoginDto {

    @Pattern(regexp = ".{2,10}",message =  "아이디는 2~10자리여야합니다.")
    private String id;

    @Pattern(regexp = "(?=.*[0-9])(?=.*\\W)(?=\\S+$).{8,16}",message = "비밀번호는 8~16자, 숫자, 특수문자를 사용하세요.")
    private String pw;
}
