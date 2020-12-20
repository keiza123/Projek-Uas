package id.haidok.database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Transaction {
    private static MysqlDataSource dataSource = new MysqlDataSource();

    private static void connectToDatabase() {
        String DB_URL = "jdbc:mysql://localhost:3306/db_haidok?serverTimezone=Asia/Jakarta";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "";

        dataSource.setUrl(DB_URL);
        dataSource.setUser(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
    }

    public static ArrayList<String[]> getHistoryOrder() {
        ArrayList<String[]> data = new ArrayList<>();
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT user,drug,status FROM transaction ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(querySelect);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("user");
                String drug = rs.getString("drug");
                int rawStatus = rs.getInt("status");

                String status = "Dikirim";
                if (rawStatus == 0) {
                    status = "Pending";
                } else if (rawStatus == 2) {
                    status = "Ditolak";
                }

                String[] tempData = {name, drug, status};
                data.add(tempData);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    public static ArrayList<String[]> getPendingOrder() {
        ArrayList<String[]> data = new ArrayList<>();
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT user,drug FROM transaction WHERE status = 0";
            PreparedStatement ps = conn.prepareStatement(querySelect);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("user");
                String drug = rs.getString("drug");

                String[] tempData = {name, drug};
                data.add(tempData);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    public static ArrayList<String[]> getHistoryOrderUser(String username) {
        ArrayList<String[]> data = new ArrayList<>();
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT drug,status FROM transaction WHERE user = ? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(querySelect);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String drug = rs.getString("drug");
                int rawStatus = rs.getInt("status");

                String status = "Dikirim";
                if (rawStatus == 0) {
                    status = "Pending";
                } else if (rawStatus == 2) {
                    status = "Ditolak";
                }

                String[] tempData = {drug, status};
                data.add(tempData);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    public static int getStatusTransactionUser(String username){
        int status = 0;
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT status FROM transaction WHERE user = ? ORDER BY id DESC " +
                    "LIMIT 1";
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

    public static int orderDrug(String username, String drug){
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String queryInsert = "INSERT INTO transaction(user, drug, status) VALUES (?, ?, 0)";
            PreparedStatement ps = conn.prepareStatement(queryInsert);
            ps.setString(1, username);
            ps.setString(2, drug);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return 0;
    }
}
