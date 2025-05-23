package com.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ErrorLog {

    private static final String LOG_FILE = "logs/error_log.txt";

    public static void log(Exception e){
        try(PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE,true))){
            out.write("["+ LocalDateTime.now()+"] ERROR: "+e.getMessage());
            e.printStackTrace(out);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
