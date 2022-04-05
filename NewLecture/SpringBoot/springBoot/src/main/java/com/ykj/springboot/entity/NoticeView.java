package com.ykj.springboot.entity;

import java.util.Date;

public class NoticeView extends Notice{
    private String name;

    public  NoticeView(){

    }

    public NoticeView(int id, String title, String memberId, Date regDate, String content, int hit, String files, boolean pub, String name) {
        super(id, title, memberId, regDate, content, hit, files, pub);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "NoticeView{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
