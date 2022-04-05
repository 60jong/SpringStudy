package com.newlecture.web.service;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeService {
    public List<NoticeView> getNoticeList() throws SQLException, ClassNotFoundException {

        return getNoticeList("title","",1);
    }
    public List<NoticeView> getNoticeList(int page) throws SQLException, ClassNotFoundException {

        return getNoticeList("title","",page);
    }
    public List<NoticeView> getNoticeList(String field, String query, int page){
        List<NoticeView> noticeViewList = new ArrayList<>();

        String sql = "select * from notice_view\n" +
                "where "+field+" like ?\n" +
                "limit 2 offset ?";

        String url = "jdbc:mysql://localhost:3306/newlecture1";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "YKJ", "991911");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,"%"+query+"%");
            st.setInt(2,(page-1)*2);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String writerId = rs.getString("writer_id");
                Date regDate = rs.getDate("regDate");
                int hit = rs.getInt("hit");
                String files = rs.getString("files");
                String content = rs.getString("content");
                int comment_Count = rs.getInt("comment_Count");
                boolean pub = rs.getBoolean("pub");
                NoticeView noticeView = new NoticeView(id, title, writerId, regDate, hit, files, content,pub,comment_Count);

                noticeViewList.add(noticeView);
            }
            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }




        return noticeViewList;
    }
    public List<NoticeView> getNoticePubList(String field, String query, int page) {
        List<NoticeView> noticeViewList = new ArrayList<>();

        String sql = "select * from notice_view\n" +
                "where "+field+" like ? and pub = true " +
                "limit 2 offset ?";

        String url = "jdbc:mysql://localhost:3306/newlecture1";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "YKJ", "991911");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,"%"+query+"%");
            st.setInt(2,(page-1)*2);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String writerId = rs.getString("writer_id");
                Date regDate = rs.getDate("regDate");
                int hit = rs.getInt("hit");
                String files = rs.getString("files");
                String content = rs.getString("content");
                int comment_Count = rs.getInt("comment_Count");
                boolean pub = rs.getBoolean("pub");
                NoticeView noticeView = new NoticeView(id, title, writerId, regDate, hit, files, content,pub,comment_Count);

                noticeViewList.add(noticeView);
            }
            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }




        return noticeViewList;
    }

    public int getNoticeCount() {
        return getNoticeCount("title","");
    }
    public int getNoticeCount(String field, String query) {
        String sql = "select count(*) as count " +
                "from notice " +
                "where "+field+" like ? ";
        String url = "jdbc:mysql://localhost:3306/newlecture1";
        int count = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "YKJ", "991911");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,"%"+query+"%");
            ResultSet rs = st.executeQuery();

            rs.next();
            count = rs.getInt("count");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return count;
    }
    public int getNoticePubCount(String field, String query) {
        String sql = "select count(*) as count " +
                "from notice " +
                "where "+field+" like ? and pub = true ";
        String url = "jdbc:mysql://localhost:3306/newlecture1";
        int count = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "YKJ", "991911");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,"%"+query+"%");
            ResultSet rs = st.executeQuery();

            rs.next();
            count = rs.getInt("count");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return count;
    }

    public Notice getNotice(int noticeId) {
        Notice notice = null;

        String url = "jdbc:mysql://localhost:3306/newlecture1";

        String sql = "select * from notice where id =  ? ";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "YKJ", "991911");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,noticeId);
            ResultSet rs = st.executeQuery();

            rs.next();
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String writerId = rs.getString("writer_id");
            String content = rs.getString("content");
            Date regDate = rs.getDate("regDate");
            int hit = rs.getInt("hit");
            String files = rs.getString("files");
            boolean pub = rs.getBoolean("pub");

            notice = new Notice(id, title, writerId, regDate, hit, files,content, pub);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notice;
    }

    public Notice getPrevNotice(int noticeId) {
        Notice notice = null;

        String url = "jdbc:mysql://localhost:3306/newlecture1";

        String sql = "select * from notice\n" +
                "where title like '%%' and regdate > (select regdate from notice where id = ?)\n" +
                "order by regdate \n" +
                "limit 1";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "YKJ", "991911");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,noticeId);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String writerId = rs.getString("writer_id");
                String content = rs.getString("content");
                Date regDate = rs.getDate("regDate");
                int hit = rs.getInt("hit");
                String files = rs.getString("files");
                boolean pub = rs.getBoolean("pub");
                notice = new Notice(id, title, writerId, regDate, hit, files,content, pub);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notice;
    }
    public Notice getNextNotice(int noticeId) {
        Notice notice = null;
        String url = "jdbc:mysql://localhost:3306/newlecture1";

        String sql = "select * from notice\n" +
                "where title like '%%' and regdate < (select regdate from notice where id = ?)\n" +
                "order by regdate desc \n" +
                "limit 1";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "YKJ", "991911");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,noticeId);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String writerId = rs.getString("writer_id");
                String content = rs.getString("content");
                Date regDate = rs.getDate("regDate");
                int hit = rs.getInt("hit");
                String files = rs.getString("files");
                boolean pub = rs.getBoolean("pub");
                notice = new Notice(id, title, writerId, regDate, hit, files,content, pub);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notice;
    }
//    -----------------------------------------------------------------------------------------------
    public int pubNoticeAll(int[] ois,int[] cis){
        String oisCSV = "";
        String cisCSV = "";

        StringBuilder sb = new StringBuilder();

        for (int i : ois) {
            sb.append(i);
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        oisCSV = sb.toString();

        sb.delete(0, sb.length());

        for (int i : cis) {
            sb.append(i);
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        cisCSV = sb.toString();


        return pubNoticeAll(oisCSV, cisCSV);
    }

    public int pubNoticeAll(List<String> ois, List<String> cis) {
        String oisCSV = String.join(",", ois);
        String cisCSV = String.join(",", cis);
        return pubNoticeAll(oisCSV,cisCSV);
    }

    public int pubNoticeAll(String oisCSV, String cisCSV) {
        int result = 0;

        String sqlOpen = "update notice set pub = 1 where id in ("+oisCSV+")";
        String sqlClose = "update notice set pub = 0 where id in ("+cisCSV+")";

        String url = "jdbc:mysql://localhost:3306/newlecture1";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "YKJ", "991911");
            Statement stOpen = con.createStatement();
            Statement stClose = con.createStatement();
            result += stOpen.executeUpdate(sqlOpen);
            result += stClose.executeUpdate(sqlClose);

            stOpen.close();
            stClose.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int closeNoticeList(int[] ids) {
        int result = 0;
        String params = "";
        for (int i = 0; i < ids.length; i++) {
            params += ids[i];
            if (i < ids.length - 1) {
                params += ",";
            }
        }
        String sql = "update notice set pub = 0 where id in ("+params+")";

        String url = "jdbc:mysql://localhost:3306/newlecture1";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "YKJ", "991911");
            Statement st = con.createStatement();
            result = st.executeUpdate(sql);

            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public int insertNotice(Notice notice){
        int result = 0;

        String sql ="insert into notice(writer_Id,title,content,pub,files) values (?,?,?,?,?)";

        String url = "jdbc:mysql://localhost:3306/newlecture1";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "YKJ", "991911");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,notice.getWriterId());
            st.setString(2,notice.getTitle());
            st.setString(3, notice.getContent());
            st.setBoolean(4,notice.isPub());
            st.setString(5, notice.getFiles());
            result = st.executeUpdate();

            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
    public int deleteNoticeAll(int[] ids){
        int result = 0;
        String params = "";
        for (int i = 0; i < ids.length; i++) {
            params += ids[i];
            if (i < ids.length - 1) {
                params += ",";
            }
        }
        String sql = "Delete from notice where id in ("+params+")";

        String url = "jdbc:mysql://localhost:3306/newlecture1";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "YKJ", "991911");
            Statement st = con.createStatement();
            result = st.executeUpdate(sql);

            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
    public int updateNotice(Notice notice) {

        return 0;
    }
    public List<Notice> getNoticeNewsetList() {
        return null;

    }



}
