import java.sql.*;
import java.util.*;

public class CRUD {
    private Statement stmt = null;
    private Scanner sc = new Scanner(System.in);

    CRUD(Statement stmt){
        this.stmt = stmt;        
    }

    public void run(){
        int n = listServices();
        if(n == 1){
            createOper();
        }else if(n == 2){
            readOper();
        }else if(n == 3){
            updateOper();
        }else if(n == 4){
            deleteOper();
        }else if(n == 5){
            System.out.println("----------Thanks For Using Our Servicess------------");
        }else{
            System.out.println("Warning: Wrong Input!!!\n");
            run();
        }

        if(n>=1 && n<=4) run();
    }

    private int listServices(){
        System.out.println();
        System.out.println("1. Register Book");
        System.out.println("2. Show All Books");
        System.out.println("3. Update Book Record");
        System.out.println("4. Delete Book Record");
        System.out.println("5. Exit");
        System.out.print("\nChoose Your Preference: ");
        int n = sc.nextInt();
        System.out.println();
        return n;
    }


    private void readOper(){
        try {
            ResultSet rs = stmt.executeQuery("select * from books");
            System.out.println("Id" + " \t " + "Book Name" + " \t " + "Description" + " \t " + "Year");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                String year = rs.getString("release_year");

                System.out.println(id + " \t " + name + " \t " + desc + " \t " + year);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createOper(){
        System.out.print("Book Name: ");
        sc.nextLine();
        String bkN = sc.nextLine();  
            
        System.out.print("Book Description: ");
        String desc = sc.nextLine();

        System.out.print("Publish Year: ");
        int yr = sc.nextInt();

        bkN = bkN.replace("'", "\\'");
        desc = desc.replace("'", "\\'");
        try {
            String query = "insert into books (name, description, release_year) values ('" + bkN + "', '" + desc + "', " + yr + ")";
            stmt.executeUpdate(query);

            System.out.println("\n-----Record Added To Table Successfully.-----");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateOper(){
        System.out.print("Enter Id of the Book: ");
        int id = sc.nextInt();

        System.out.print("Enter Year: ");
        int yr = sc.nextInt();
        try {
            String query = "update books set release_year = "+yr+" where id ="+id;
            stmt.executeUpdate(query);

            System.out.println("\n-----Record Updated Sucessfully.-----");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteOper(){
        System.out.print("Enter Id of the Book: ");
        int id = sc.nextInt();

        try {
            String query = "delete from books where id = "+id;
            stmt.executeUpdate(query);

            System.out.println("\n-----Record Deleted Successfully.-----");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
