package com.thymeleaf.study.service;

import com.thymeleaf.study.domain.QnaBoard;
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

    public void deleteQnaBoard(int uid){
     boardMapper.deleteQnaBoard(uid);

    }
    public void updateQnaBoard(QnaBoardDto editedPost){
        QnaBoard qnaBoard = new QnaBoard();
        qnaBoard.setTitle(editedPost.getTitle());
        qnaBoard.setContent(editedPost.getContent());
        qnaBoard.setUid(editedPost.getUid());

     boardMapper.updateQnaBoard(qnaBoard);
    }
}
