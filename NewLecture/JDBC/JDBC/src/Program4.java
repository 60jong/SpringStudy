import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program4 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/newlecture1";
        String user = "YKJ";
        String pass = "991911";

        int id = 10;

        String sql = "delete notice where id=?";




        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,id);

            int rs = pst.executeUpdate();
            System.out.println(rs);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
