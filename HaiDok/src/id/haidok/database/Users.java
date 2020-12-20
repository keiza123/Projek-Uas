package id.haidok.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {
    private static MysqlDataSource dataSource = new MysqlDataSource();

    private static void connectToDatabase() {
        String DB_URL = "jdbc:mysql://localhost:3306/db_haidok?serverTimezone=Asia/Jakarta";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "";

        dataSource.setUrl(DB_URL);
        dataSource.setUser(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
    }

    public static boolean checkUser(String username, String password) {
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(querySelect);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return false;
    }

    public static Object[] login(String username, String password) {
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(querySelect);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            Object[] user = new Object[2];

            rs.next();

            user[0] = rs.getString("username");
            user[1] = rs.getInt("type");

            return user;

        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    public static int getAccountByUsername(String username) {
        int status = 0;
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT username FROM users WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(querySelect);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                status = 1;
            }

            return status;
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return status;
    }

    public static int addUser(String name, String password) {
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String queryInsert = "INSERT INTO users(username, password, type) VALUES (?, ?, 0)";
            PreparedStatement ps = conn.prepareStatement(queryInsert);
            ps.setString(1, name);
            ps.setString(2, password);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return 0;
    }
}
