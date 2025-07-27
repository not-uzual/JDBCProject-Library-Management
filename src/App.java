import java.sql.*;

public class App {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;

        try {

            con = DatabaseConnection.connect();

            if (con != null && !con.isClosed()) {
                System.out.println("Successfully Connected To MySQL!!!\n");
                
                stmt = con.createStatement();

                System.out.println("-----WELCOME TO THE LIBRARY-----");

                CRUD crud = new CRUD(stmt);
                crud.run();
            }

        } catch (Exception e) {
           e.printStackTrace();
           
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                System.out.println("\nConnection Closed....");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }       
}

