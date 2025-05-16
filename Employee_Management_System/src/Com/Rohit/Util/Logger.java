package Com.Rohit.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String LOG_File = "logs.log";

    public static void log(String message){
        try(FileWriter writer = new FileWriter(LOG_File,true)){
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss"));

            writer.write("["+timestamp+"]"+message+ "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
