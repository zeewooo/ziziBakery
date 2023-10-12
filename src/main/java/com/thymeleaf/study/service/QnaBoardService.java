package com.thymeleaf.study.service;

import com.thymeleaf.study.dao.QnaBoardDao;
import com.thymeleaf.study.domain.QnaBoard;
import com.thymeleaf.study.dto.PagingDto;
import com.thymeleaf.study.dto.QnaBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnaBoardService {
    QnaBoardDao qnaBoardDao;

    @Autowired
    public QnaBoardService(QnaBoardDao qnaBoardDao) {
        this.qnaBoardDao = qnaBoardDao;
    }


    public void writeQnaBoard(QnaBoardDto qnaBoardDto){
        QnaBoard qnaBoard = new QnaBoard();
        qnaBoard.setCategoryUid(qnaBoardDto.getCategory_uid());
        qnaBoard.setTitle(qnaBoardDto.getTitle());
        qnaBoard.setContent(qnaBoardDto.getContent());
        qnaBoard.setUserUid(qnaBoardDto.getUserUid());
        qnaBoardDao.writeQnaBoard(qnaBoard);
    }
    public List<QnaBoardDto>  selectQnaBoard(PagingDto pagingDto) {
        return qnaBoardDao.selectQnaBoard(pagingDto);
    }

    public long getTotalPostCount(PagingDto pagingDto){
        return qnaBoardDao.getTotalPostCount(pagingDto);
    }



}
