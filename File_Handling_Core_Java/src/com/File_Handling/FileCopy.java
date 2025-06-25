package com.File_Handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {

    public static void copyContent(String Filea,String Fileb) {

        try (BufferedReader rd = new BufferedReader(new FileReader(Filea));
             FileWriter wrt = new FileWriter(Fileb)) {

            String line;

            while ((line = rd.readLine()) != null) {

                wrt.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File Copied");

    }


    public static void main(String[] args) {

        String filea = "C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Rohit_Java\\File_Handling_Core_Java\\src\\com\\File_Handling\\File_Con\\filea.txt";
        String fileb = "C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Rohit_Java\\File_Handling_Core_Java\\src\\com\\File_Handling\\File_Con\\fileb.txt";

        copyContent(filea,fileb);
    }
}
