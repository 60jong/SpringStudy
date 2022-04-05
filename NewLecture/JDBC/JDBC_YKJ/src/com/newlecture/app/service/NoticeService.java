package com.newlecture.app.service;

import com.newlecture.app.entity.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeService {
    private String url = "jdbc:mysql://localhost:3306/newlecture1";
    private String user = "root";
    private String password = "991911";
    private String driver = "com.mysql.cj.jdbc.Driver";

    public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {


        String sql = "select @rownum:=@rownum+1 num, n.* " +
                "from (select * from notice order by regdate desc) as n,(select @rownum:=0) as r "+" "+"where "+field+" like '%"+query+"%' "+
                "limit 5 offset "+(page-1)*5+";";

        String id;
        String title;
        String writerId;
        String content;
        Date regDate;
        int hit;
        String files;

        List<Notice> list = new ArrayList<Notice>();

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()){
            Notice notice = new Notice(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("writer_id"),
                    rs.getString("content"),
                    rs.getDate("regdate"),
                    rs.getInt("hit"),
                    rs.getString("files")
            );

            list.add(notice);
        }

        return list;
    }
    public int getCount() throws ClassNotFoundException, SQLException {
        int count = 0;
        String sql = "select count(id) countid from notice";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        rs.next();
        count = rs.getInt("countid");

        return count;
    }

}
