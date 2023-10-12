package com.thymeleaf.study.dao;

import com.thymeleaf.study.domain.QnaBoard;
import com.thymeleaf.study.dto.PagingDto;
import com.thymeleaf.study.dto.QnaBoardDto;
import com.thymeleaf.study.mybatis.mappers.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QnaBoardDao {
    BoardMapper boardMapper;

@Autowired
public QnaBoardDao(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }
    public void writeQnaBoard(QnaBoard qnaBoard){
      boardMapper.insertQnaBoard(qnaBoard);
    }

    public List<QnaBoardDto> selectQnaBoard(PagingDto pagingDto){
    return boardMapper.selectQnaBoard(pagingDto);
    }

    public long getTotalPostCount(PagingDto pagingDto){
    return boardMapper.getTotalPostCount(pagingDto);

    }


}
