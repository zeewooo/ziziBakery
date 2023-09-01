package com.thymeleaf.study.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
public class UserDto {
    private int uid;

//    @NotBlank(message ="아이디를 입력해주세요")
    @Pattern(regexp = ".{2,10}",message =  "아이디는 2~10자리여야합니다.")
    private String id;

//    @NotBlank(message ="비밀번호를 입력해주세요")
    @Pattern(regexp = "(?=.*[0-9])(?=.*\\W)(?=\\S+$).{8,16}",message = "비밀번호는 8~16자, 숫자, 특수문자를 사용하세요.")
    private String pw;

    @NotBlank(message ="이름을 입력해주세요")
    private  String user_name;

//    @NotBlank(message ="메일주소를 입력해주세요")
    @Pattern(regexp = "(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
    private String e_mail;

}
