import java.sql.*;

public class Main {
    //url and username, password info
    public static final String DB_URL = "jdbc:mysql://localhost/employees";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";
    public static void main(String[] args) {


        Connection connect = null;
        Statement st= null;
        String sql ="SELECT * FROM employees";


        try{ // connection
           connect= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
           st=connect.createStatement();
           ResultSet data =st.executeQuery(sql);
           while(data.next()){ //print loop
               System.out.println("ID: "+ data.getInt("id") + " Name: " +data.getString("name")+" Position: "+ data.getString("position")+" Salary: "+ data.getInt("salary"));
           }

        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }
}