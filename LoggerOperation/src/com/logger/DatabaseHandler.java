package com.logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

public class DatabaseHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/loggerdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void insertLoges(LocalDateTime timestamp,Map<String, Integer> logCount){
        String sql  ="INSERT INTO log1(timestamp,error_count,warning_count,info_count)VALUES (?,?,?,?)";

        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql)){

//            ps.setTimestamp(1, Timestamp.valueOf(timestamp));
//            ps.setInt(2,logCount.getOrDefault("ERROR",0));
//            ps.setInt(3,logCount.getOrDefault("WARNING",0));
//            ps.setInt(4,logCount.getOrDefault("INFO",0));


            int errorCount = logCount.getOrDefault("ERROR", 0);
            int warningCount = logCount.getOrDefault("WARNING", 0);
            int infoCount = logCount.getOrDefault("INFO", 0);

            ps.setTimestamp(1, Timestamp.valueOf(timestamp));
            ps.setInt(2, errorCount);
            ps.setInt(3, warningCount);
            ps.setInt(4, infoCount);
            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Log entry inserted  successfully:");
                System.out.println("Timestamp     : " + timestamp);
                System.out.println("Error Count   : " + errorCount);
                System.out.println("Warning Count : " + warningCount);
                System.out.println("Info Count    : " + infoCount);
            } else {
                System.out.println("No  rows inserted.");
            }


        } catch (Exception e) {
            throw new DatabaseProcessException("Error in data saving in database:"+e);
        }
    }
}
