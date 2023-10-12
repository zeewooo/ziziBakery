package com.thymeleaf.study.mybatis.mappers;

import com.thymeleaf.study.domain.QnaBoard;
import com.thymeleaf.study.dto.PagingDto;
import com.thymeleaf.study.dto.QnaBoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insertQnaBoard(QnaBoard qnaBoard);
    List<QnaBoardDto> selectQnaBoard(PagingDto pagingDto);

    long getTotalPostCount(PagingDto pagingDto);

    QnaBoardDto selectQnaBoardDetail(int uid);


    void deleteQnaBoard(int uid);

    void updateQnaBoard(QnaBoard editedPost);
}
