import java.sql.*;

public class DataConnection {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee","root","root");

            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("Select id,e_name from employee");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2));
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
