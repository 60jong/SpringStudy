package com.ykj.springboot.service;


import com.ykj.springboot.dao.NoticeDao;
import com.ykj.springboot.entity.NoticeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImp implements NoticeService{
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<NoticeView> getNoticeList(int page,String field,String query) {
        int size = 5;
        int offset = (page-1) / size * size;
        List<NoticeView> noticeList = noticeDao.getNoticeList(size,offset,page,field,query);
        return noticeList;
    }

    @Override
    public NoticeView getNotice(int id) {

        NoticeView notice = noticeDao.getNotice(id);
        return notice;
    }
}
