package id.haidok.database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Promise {
    private static MysqlDataSource dataSource = new MysqlDataSource();

    private static void connectToDatabase() {
        String DB_URL = "jdbc:mysql://localhost:3306/db_haidok?serverTimezone=Asia/Jakarta";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "";

        dataSource.setUrl(DB_URL);
        dataSource.setUser(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
    }

    public static ArrayList<String[]> getHistoryRoom() {
        ArrayList<String[]> data = new ArrayList<>();
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT user,room,time,status FROM promise ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(querySelect);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nama = rs.getString("user");
                String room = rs.getString("room");
                String time = rs.getString("time");
                int rawStatus = rs.getInt("status");

                String status = "Selesai";
                if (rawStatus == 0) {
                    status = "Pending";
                } else if (rawStatus == 2) {
                    status = "Ditolak";
                }

                String[] tempData = {nama, room, time, status};
                data.add(tempData);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    public static ArrayList<String[]> getPendingRoom() {
        ArrayList<String[]> data = new ArrayList<>();
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT user,room,time FROM promise WHERE status = 0";
            PreparedStatement ps = conn.prepareStatement(querySelect);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("user");
                String drug = rs.getString("room");
                String time = rs.getString("time");

                String[] tempData = {name, drug, time};
                data.add(tempData);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    public static int acceptRoom(String username) {
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String queryUpdate = "UPDATE promise SET status = 1 WHERE user = ? AND status = 0";
            PreparedStatement ps = conn.prepareStatement(queryUpdate);
            ps.setString(1, username);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return 0;
    }

    public static int rejectRoom(String username) {
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String queryUpdate = "UPDATE promise SET status = 2 WHERE user = ? AND status = 0";
            PreparedStatement ps = conn.prepareStatement(queryUpdate);
            ps.setString(1, username);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return 0;
    }

    public static String[] getDetailRoom(String username) {
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT complaint, description FROM promise WHERE user = ? AND status = 0";
            PreparedStatement ps = conn.prepareStatement(querySelect);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            rs.next();

            return new String[]{rs.getString("complaint"), rs.getString("description")};

        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    public static ArrayList<String[]> getHistoryRoomUser(String username) {
        ArrayList<String[]> data = new ArrayList<>();
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT complaint,room,time,status FROM promise WHERE user = ? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(querySelect);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String complaint = rs.getString("complaint");
                String room = rs.getString("room");
                String time = rs.getString("time");
                int rawStatus = rs.getInt("status");

                String status = "Selesai";
                if (rawStatus == 0) {
                    status = "Pending";
                } else if (rawStatus == 2) {
                    status = "Ditolak";
                }

                String[] tempData = {complaint, room, time, status};
                data.add(tempData);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    public static int getStatusPromiseUser(String username){
        int status = 0;
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT status FROM promise WHERE user = ? ORDER BY id DESC LIMIT 1";
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

    public static int makePromise(String username, String complaint, String description,
                                  String room, String time){
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String queryInsert = "INSERT INTO promise(user, complaint, description, room, time, status) VALUES (?, ?, ?, ?, ?, 0)";
            PreparedStatement ps = conn.prepareStatement(queryInsert);
            ps.setString(1, username);
            ps.setString(2, complaint);
            ps.setString(3, description);
            ps.setString(4, room);
            ps.setString(5, time);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return 0;
    }
}
