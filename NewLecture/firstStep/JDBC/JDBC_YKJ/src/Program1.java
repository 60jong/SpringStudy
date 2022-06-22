import java.sql.*;

public class Program1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/newlecture1";
        String user = "root";
        String password = "991911";
        String driver = "com.mysql.cj.jdbc.Driver";

        String sql = "select * from notice";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        rs.next();

        System.out.println(rs.getString("ID"));
    }
}
