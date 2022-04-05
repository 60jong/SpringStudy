package com.newlecture.web.entity;

import java.util.Date;

public class Comment {
    private int id;
    private String content;
    private Date regdate;
    private String writerId;
    private String NoticeId;

    public Comment(int id, String content, Date regdate, String writerId, String noticeId) {
        this.id = id;
        this.content = content;
        this.regdate = regdate;
        this.writerId = writerId;
        NoticeId = noticeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public String getNoticeId() {
        return NoticeId;
    }

    public void setNoticeId(String noticeId) {
        NoticeId = noticeId;
    }



}
