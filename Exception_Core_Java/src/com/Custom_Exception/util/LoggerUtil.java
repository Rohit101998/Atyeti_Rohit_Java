package com.Custom_Exception.util;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {
    private static final String LOG_FILE = "app.log";

    public static void log(String message, String eMessage){
        try(FileWriter writer = new FileWriter(LOG_FILE,true)){
          String timestamp = LocalDateTime.now()
                  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:dd"));

          writer.write("["+timestamp+"]"+message+"\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
