package com.thymeleaf.study.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class QnaBoard {
    int uid;
    int userUid;
    int categoryUid;
    String title;
    String content;
    LocalDate regdate;
}
