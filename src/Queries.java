import java.sql.*;

public class Queries {
    String queryEmail ;
    String queryPassword ;
    String jdbcUrl = ("jdbc:sqlite:C:\\Users\\pc\\Desktop\\motifyusers.db");

    public void insert(String email, String password) {
        Class.forName("org.sqlite.JDBC");
        String sql = "INSERT INTO users (email,password) VALUES(?,?)";

        try (Connection conn = DriverManager.getConnection(jdbcUrl); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public void signUpQuery(){

        Connection con = null ;
        String jdbcUrl = ("jdbc:sqlite:/C:\\Users\\LEGION\\wayto_pay.db");
        String email = "oztekinberkin5@gmail.com";
        try {
            con = DriverManager.getConnection(jdbcUrl);
            String sql =("INSERT INTO users (name , password , telephone , address , gender) VALUES  + email");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                String name = result.getString("NAME");
                String password = result.getString("PASSWORD");
                System.out.println(name +  " | " + password);
            }

        }catch (Exception ex){
            System.out.println(ex.getClass().getName() + " : " + ex.getMessage());
            System.out.println(0);
        }
        System.out.println("Database opened successfully");
    }

     */
    public void loginQuery(String email , String password){

        Connection con = null ;
        String sql = "SELECT EMAİL,PASSWORD FROM users WHERE EMAİL = ? AND PASSWORD = ?";

        try (Connection conn = DriverManager.getConnection(jdbcUrl); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()){
                queryEmail = resultSet.getString("EMAİL");
                queryPassword= resultSet.getString("PASSWORD");

                System.out.println(queryEmail + " | " + queryPassword);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
