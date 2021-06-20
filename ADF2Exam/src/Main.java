import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager
                .getConnection("jdbc:sqlserver://localhost:1434;databaseName=SchoolDB;integratedSecurity=true")) {
            System.out.println("\nConnection successful");

            System.out.println("\nChoose 1 option below:");
            System.out.println("1. Add new student.");
            System.out.println("2. Delete");
            System.out.println("3. Display all student");
            System.out.println("4. Exit.");
            int answer = Integer.parseInt(sc.nextLine());
            String sql = "";
            String enrollID;
            String firstName;
            String lastName;
            String age;
            switch (answer) {
            case 1:
                try {

                    System.out.print("Enter Enroll ID: ");
                    enrollID = sc.nextLine();
                    System.out.print("Enter First Name: ");
                    firstName = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    lastName = sc.nextLine();
                    System.out.print("Enter Age: ");
                    age = sc.nextLine();

                    sql = "INSERT Students VALUES (?,?,?,?)";
                    PreparedStatement psmt = conn.prepareStatement(sql);
                    psmt.setString(1, enrollID);
                    psmt.setString(2, firstName);
                    psmt.setString(3, lastName);
                    psmt.setString(4, (String) age);
                    ResultSet rs = psmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("Execute Successful");
                    } else {
                        System.out.println("Execute Failed");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 2:
                try {
                    System.out.print("Enter Enroll ID: ");
                    enrollID = sc.nextLine();
                    sql = "DELETE FROM Students WHERE EnrollID = ?";
                    PreparedStatement psmt = conn.prepareStatement(sql);
                    psmt.setString(1, enrollID);
                    ResultSet rs = psmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("Execute Successful");
                    } else {
                        System.out.println("Execute Failed");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            case 3:
                try {
                    sql = "SELECT * FROM Students";
                    PreparedStatement psmt = conn.prepareStatement(sql);
                    ResultSet rs = psmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("Execute Successful");
                    } else {
                        System.out.println("Execute Failed");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            default:
                System.out.print("Please enter an answer: ");
                answer = sc.nextInt();
                break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("\nConnection unsuccessful");
        }

    }
}
