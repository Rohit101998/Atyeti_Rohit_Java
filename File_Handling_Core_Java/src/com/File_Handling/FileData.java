package com.File_Handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileData {

    public static void countFileData(String inFile,String outFile){
        int lC = 0;
        int wC = 0;
        int cC = 0;
        try(BufferedReader rd = new BufferedReader(new FileReader(inFile))){

            String line;

            while ((line = rd.readLine())!= null){
                lC++;     // Count the line
                wC += line.split("\\s+").length;   // Count the Word
                cC += line.length();   //Count the Characters

            }

            String result =  "Line: "+ lC +"\n"+
                    "Word: " +wC +"\n"+
                    "Characters: "+cC +"\n";
            try(FileWriter wrt = new FileWriter(outFile)){
                wrt.write(result);
            }

            System.out.println("Result written to outFile: "+result);

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        String infile = "C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Rohit_Java\\File_Handling_Core_Java\\src\\com\\File_Handling\\File_Con\\filea.txt";
        String outfile = "C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Rohit_Java\\File_Handling_Core_Java\\src\\com\\File_Handling\\File_Con\\outputfile.txt";

        countFileData(infile,outfile);

    }
}
