import java.sql.*;
import java.util.Date;

public class Program2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/newlecture1";
        String user = "YKJ";
        String pass = "991911";

        String title = "myObject";
        String writer_id = "YKJ";
        String content = "I am a student of KU";

        String sql = "insert into notice(title,writer_id,content) values(?,?,?)";




        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,title);
            pst.setString(2,writer_id);
            pst.setString(3,content);
            int rs = pst.executeUpdate();
            System.out.println(rs);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
