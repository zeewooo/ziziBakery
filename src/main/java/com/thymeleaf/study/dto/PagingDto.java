package com.thymeleaf.study.dto;

import lombok.Data;

@Data
public class PagingDto {
    private int page = 1; //현재 페이지 번호(url) :
    private int Count = 10; //보여줄 페이지 번호 개수 :
    private int offset;
    private int startPage; //시작페이지
    private int endPage;// 끝 페이지
    private int totalPages;//전체 게시글 수

}
