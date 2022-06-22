package com.ykj.springboot.dao;


import com.ykj.springboot.entity.Notice;
import com.ykj.springboot.entity.NoticeView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoticeDao {

    List<NoticeView> getNoticeList(int size,int offset,int page,String field,String query);

    NoticeView getNotice(int id);

    int insert(Notice notice);
}
