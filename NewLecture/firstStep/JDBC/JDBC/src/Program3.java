import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/newlecture1";
        String user = "YKJ";
        String pass = "991911";

        String title = "myObject";
        String writer_id = "YKJ";
        String content = "I am a student of KU";

        String sql = "update notice " +
                "set title=?," +
                "writer_id=? " +
                "where id=10";




        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(2, "writer10");
            pst.setString(1,"title10");

            System.out.println(pst.executeUpdate());

            pst.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
