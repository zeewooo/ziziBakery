package com.thymeleaf.study.service;

import com.thymeleaf.study.dto.QnaBoardDto;
import com.thymeleaf.study.mybatis.mappers.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaBoardDetailService {
     BoardMapper boardMapper;
 @Autowired
    public QnaBoardDetailService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public QnaBoardDto selectQnaBoardDetail(int uid){
     return boardMapper.selectQnaBoardDetail(uid);
    }
}
