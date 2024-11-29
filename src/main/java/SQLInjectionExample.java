import java.sql.*;

public class SQLInjectionExample {
    public static void main(String[] args) throws SQLException {
        // ó
        String userInputA = args[1];
        // ó
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
        // ó
        String query = "SELECT * FROM users WHERE username = ?;";
        // ó
        PreparedStatement stmt = con.prepareStatement(query);
        // ó
        stmt.setString(1, userInputA);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }
    }
}
