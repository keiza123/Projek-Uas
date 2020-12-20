package id.haidok.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Drug {
    private static MysqlDataSource dataSource = new MysqlDataSource();

    private static void connectToDatabase() {
        String DB_URL = "jdbc:mysql://localhost:3306/db_haidok?serverTimezone=Asia/Jakarta";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "";

        dataSource.setUrl(DB_URL);
        dataSource.setUser(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
    }

    public static ArrayList<String[]> getListDrug() {
        ArrayList<String[]> data = new ArrayList<>();
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT name,price FROM drug_table";
            PreparedStatement ps = conn.prepareStatement(querySelect);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String price = rs.getString("price");

                String[] tempData = {name, price};
                data.add(tempData);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    public static int sendOrder(String username) {
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String queryUpdate = "UPDATE transaction SET status = 1 WHERE user = ? AND status = 0";
            PreparedStatement ps = conn.prepareStatement(queryUpdate);
            ps.setString(1, username);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return 0;
    }

    public static int rejectOrder(String username) {
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String queryUpdate = "UPDATE transaction SET status = 2 WHERE user = ? AND status = 0";
            PreparedStatement ps = conn.prepareStatement(queryUpdate);
            ps.setString(1, username);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return 0;
    }

    public static int getDrugByName(String name) {
        int status = 0;
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT name FROM drug_table WHERE name = ?";
            PreparedStatement ps = conn.prepareStatement(querySelect);
            ps.setString(1, name);

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

    public static int addDrug(String name, String price) {
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String queryInsert = "INSERT INTO drug_table(name,price) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(queryInsert);
            ps.setString(1, name);
            ps.setString(2, price);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return 0;
    }

    public static int deleteDrug(String name) {
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String queryDelete = "DELETE FROM drug_table WHERE name = ?";
            PreparedStatement ps = conn.prepareStatement(queryDelete);
            ps.setString(1, name);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return 0;
    }
}
