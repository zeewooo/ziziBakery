package com.thymeleaf.study.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class QnaBoardDto {
    private int uid;
    private String title;
    private String content;
    private LocalDate regdate;
    private int category_uid;
    private String c_name;
    private String id;
    private int currentPage;
    private int totalPages;
    private int userUid;


}
