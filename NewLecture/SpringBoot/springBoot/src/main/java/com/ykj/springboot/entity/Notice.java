package com.ykj.springboot.entity;

import java.util.Date;

public class Notice {
    private int id;
    private String title;
    private String memberId;
    private Date regDate;
    private String content;
    private int hit;
    private String files;
    private boolean pub;


    public Notice() {
    }

    public Notice(int id, String title, String memberId, Date regDate, String content, int hit, String files, boolean pub) {
        this.id = id;
        this.title = title;
        this.memberId = memberId;
        this.regDate = regDate;
        this.content = content;
        this.hit = hit;
        this.files = files;
        this.pub = pub;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }
    public boolean isPub() {
        return pub;
    }
    public void setPub(boolean pub) {
        this.pub = pub;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", memberId='" + memberId + '\'' +
                ", regDate=" + regDate +
                ", content='" + content + '\'' +
                ", hit=" + hit +
                ", files='" + files + '\'' +
                ", pub=" + pub +
                '}';
    }
}
