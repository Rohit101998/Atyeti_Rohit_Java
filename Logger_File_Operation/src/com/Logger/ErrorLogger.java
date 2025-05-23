package com.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorLogger {
    private static final String Log_File ="logs/error_log.txt";

    public static void log(Exception e){
         try(PrintWriter out= new PrintWriter(new FileWriter(Log_File,true)) ){
             out.println("ERROR: "+e.getMessage());
             e.printStackTrace(out);
         }catch (IOException ex){
             ex.printStackTrace();
         }
    }
}
