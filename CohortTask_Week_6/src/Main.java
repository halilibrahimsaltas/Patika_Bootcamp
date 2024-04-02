import java.sql.*;

public class Main {
    public static final String DB_URL = "jdbc:mysql://localhost/company";

    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        Connection conn=null;
        Statement st=null;
        String sql ="SELECT * FROM employees";

        try{
            conn= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            st=conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("İsim: "+resultSet.getString("name"));
                System.out.println("Pozisyon: "+resultSet.getString("position"));
                System.out.println("Maaş: "+resultSet.getDouble("salary"));
                System.out.println("#########################");

            }
            st.close();
            conn.close();

        }catch(SQLException ex){
            System.out.println("SQLException: "+ex.getMessage());
        }

    }

}