package com.logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseHandlerTest {

    DatabaseHandler databaseHandler;

    private static final String URL="jdbc:mysql://localhost:3306/loggerdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Mock
    ConcurrentMap<String, AtomicInteger> map= new ConcurrentHashMap<>();

    LocalDateTime currentDateTime = LocalDateTime.now();

    @BeforeEach
    void setUp() {
        databaseHandler = new DatabaseHandler();
    }

    @AfterEach
    void tearDown() {
    }
    @AfterEach
    void cleanUp(){
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM log1");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void testInsertLogesTrue() {


        LocalDateTime currentTimeDate = LocalDateTime.now().withNano(0);

        ConcurrentMap<String, AtomicInteger> map = new ConcurrentHashMap<>();
        map.put("ERROR", new AtomicInteger(7));
        map.put("WARNING", new AtomicInteger(4));
        map.put("INFO", new AtomicInteger(9));


        databaseHandler.insertLoges(currentTimeDate, map);


        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM log1 WHERE timestamp = ?")) {


            ps.setTimestamp(1, Timestamp.valueOf(currentTimeDate));

            try (ResultSet rs = ps.executeQuery()) {


                assertTrue(rs.next(), "Data is not inserted into log1 table");

                assertEquals(7, rs.getInt("error_count"), "ERROR count mismatch");
                assertEquals(4, rs.getInt("warning_count"), "WARNING count mismatch");
                assertEquals(9, rs.getInt("info_count"), "INFO count mismatch");
            }

        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception during database verification: " + e.getMessage());
        }



    }
    }
