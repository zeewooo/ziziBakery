package com.thymeleaf.study.service;

import com.thymeleaf.study.dao.QnaBoardDao;
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
        qnaBoardDao.writeQnaBoard(qnaBoardDto);
    }
    public List<QnaBoardDto>  selectQnaBoard(PagingDto pagingDto) {
        return qnaBoardDao.selectQnaBoard(pagingDto);
    }

    public long getTotalPostCount(PagingDto pagingDto){
        return qnaBoardDao.getTotalPostCount(pagingDto);
    }



}
