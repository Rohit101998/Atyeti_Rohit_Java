package com.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/logdb";
    private static final String USER = "root";
    private static final  String PASSWORD = "root";

    public void insertErrorLogs(Map<String,Integer> errors){
        String sql = "INSERT INTO error_logs (error_message, count) VALUES (?, ?)";
        insertIntoDB(errors,sql);
    }
    public void insertWarningLogs(Map<String,Integer> warnings){
        String sql = "INSERT INTO warning_logs (warning_message, count) VALUES (?, ?)";
        insertIntoDB(warnings,sql);
    }
    public void insertSuccessLogs(Map<String,Integer> successes){
        String sql = "INSERT INTO success_logs (success_message, count) VALUES (?, ?)";
        insertIntoDB(successes,sql);
    }

    private void insertIntoDB(Map<String,Integer> map, String sql){
        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql)){


            for (Map.Entry<String,Integer> entry : map.entrySet()){
                System.out.println("Inserting: " + entry.getKey() + " => " + entry.getValue());
                ps.setString(1,entry.getKey());
                ps.setInt(2,entry.getValue());


                ps.addBatch();
            }
            ps.executeBatch();

        } catch (SQLException e) {
            ErrorLogger.log(e);
        }
    }
}
