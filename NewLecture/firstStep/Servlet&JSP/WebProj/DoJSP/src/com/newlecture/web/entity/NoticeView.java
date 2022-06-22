package com.newlecture.web.entity;

import java.util.Date;

public class NoticeView extends Notice{
    private int comment_Count;

    public int getComment_Count() {
        return comment_Count;
    }

    public void setComment_Count(int comment_Count) {
        this.comment_Count = comment_Count;
    }

    public NoticeView(){

    }

    public NoticeView(int id, String title, String writerId, Date regDate, int hit, String files, String content, boolean pub ,int comment_count) {
        super(id, title, writerId, regDate, hit, files, content, pub);
        this.comment_Count = comment_count;
    }
}
