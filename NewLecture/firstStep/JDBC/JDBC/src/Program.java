import java.sql.*;
import java.util.Date;

public class Program {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/newlecture1";
        String user = "YKJ";
        String pass = "991911";

        String sql = "Select * From notice where hit > 3";

        int id;
        String title;
        String writer_id;
        String content;
        Date regdate;
        int hit;
        String files;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                id = rs.getInt("id");
                title = rs.getString("title");
                writer_id = rs.getString("writer_id");
                content = rs.getString("content");
                regdate = rs.getDate("regdate");
                hit = rs.getInt("hit");
                files = rs.getString("files");

                System.out.printf("ID : %d TITLE : %s WRITER_ID : %s CONTENT : %s REGDATE : %s HIT : %d FILES : %s\n",id,title,writer_id,content,
                        regdate,hit,files);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
