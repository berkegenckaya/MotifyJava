import java.sql.*;

public class Queries {
    String queryUsername;
    String queryEmail ;
    String queryPassword ;
    String jdbcUrl = ("jdbc:sqlite:/C:\\Users\\pc\\Desktop\\database\\motifyjava.db");

    public void insert(String username ,String email, String password) {


        String sql = "INSERT INTO Users (username,email,password) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(jdbcUrl); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean loginQuery(String email ,String password ){
        boolean isValid = false;
        Connection con = null ;
        String sql = "SELECT * FROM Users WHERE email = ? AND password = ? ";

        try (Connection conn = DriverManager.getConnection(jdbcUrl); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,email);
            pstmt.setString(2,password);


            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()){
                queryEmail = resultSet.getString("email");
                queryPassword = resultSet.getString("password");


                System.out.println(queryEmail +" "+queryPassword );
                isValid = true;
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isValid;
    }


}
