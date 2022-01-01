import java.sql.*;

public class DatabaseConnection {

    public static Connection connect() {
        Connection conn = null;
        try {

            String url = "jdbc:sqlite:C:\\Users\\pc\\Desktop\\motifyusers.db";

            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
        return conn;
    }
    public static void insert(String username, String password){
        String sql = "INSERT INTO users(username,password) VALUES(?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        connect();
        insert("admin2","1234");
    }
}
