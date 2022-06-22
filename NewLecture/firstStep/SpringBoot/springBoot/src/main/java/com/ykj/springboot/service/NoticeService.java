package com.ykj.springboot.service;

import com.ykj.springboot.entity.Notice;
import com.ykj.springboot.entity.NoticeView;

import java.util.List;

public interface NoticeService {

    NoticeView getNotice(int id);

    List<NoticeView> getNoticeList(int page, String field, String query);
}
