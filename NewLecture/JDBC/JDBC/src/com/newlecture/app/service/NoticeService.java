package com.newlecture.app.service;

import com.newlecture.app.entity.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeService {
    private String url = "jdbc:mysql://localhost:3306/newlecture1";
    private String user = "YKJ";
    private String pass = "991911";
    private String driver = "com.mysql.cj.jdbc.Driver";

    public List<Notice> getList(int page, String field, String query) throws SQLException, ClassNotFoundException {

        int offset = (page-1) * 10;
        String sql = "select (@rownum:=@rownum+1) as num, a.* " +
                "from (select * from notice order by regdate desc) as a , " +
                "(select @rownum:=0) as r " +
                "where "+field+" Like '%"+query+"%' "+ "limit 10 offset ?;";

        int id;
        String title;
        String writer_id;
        String content;
        Date regdate;
        int hit;
        String files;


        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user,pass);
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, offset);
        ResultSet rs = pst.executeQuery();

        List<Notice> noticeList = new ArrayList<Notice>();

        while (rs.next()) {
            id = rs.getInt("id");
            title = rs.getString("title");
            writer_id = rs.getString("writer_id");
            content = rs.getString("content");
            regdate = rs.getDate("regdate");
            hit = rs.getInt("hit");
            files = rs.getString("files");

            Notice notice = new Notice(
                    id,
                    title,
                    writer_id,
                    content,
                    regdate,
                    hit,
                    files
            );
            noticeList.add(notice);
        }

        rs.close();
        pst.close();
        con.close();

        return noticeList;




    }
    public int insert(Notice notice) throws SQLException, ClassNotFoundException {

        String sql = "insert into notice(title,writer_id,content,files) values(?,?,?,?)";

        String title = notice.getTitle();
        String writer_id = notice.getWriter_id();
        String content = notice.getContent();
        String files = notice.getFiles();

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user,pass);
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,title);
        pst.setString(2,writer_id);
        pst.setString(3,content);
        pst.setString(4,files);
        int rs = pst.executeUpdate();

        pst.close();
        con.close();

        return rs;
    }
    public int update(Notice notice) throws SQLException, ClassNotFoundException {
        String title = notice.getTitle();
        String writer_id = notice.getWriter_id();
        String content = notice.getContent();

        String sql = "update notice " +
                "set title=?," +
                "writer_id=?, " +
                "content =? " +
                "where id=10";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(2, "writer10");
        pst.setString(1,"title10");
        pst.setString(3,"content10");

        int rs = pst.executeUpdate();

        pst.close();
        con.close();
        return rs;
    }
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete notice where id=?";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1,id);

        int rs = pst.executeUpdate();

        pst.close();
        con.close();

        return rs;
    }

    public int getCount() throws ClassNotFoundException, SQLException {
        int count = 0;
        String sql = "select count(id) countID from notice";


        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        rs.next();
        count = rs.getInt("countID");



        rs.close();
        st.close();
        con.close();

        return count;
    }
}
