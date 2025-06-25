package com.File_Handling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class File_Concat {

    public static void fileConcat(String folder){
        File dir = new File(folder);
        File[] files = dir.listFiles();

        for(File file:files){
            if(file.isFile()){
                String line;
                try(BufferedReader inputStream = new BufferedReader(new FileReader(file))){

                    while((line=inputStream.readLine())!=null){
                        System.out.println(line);

                    }

                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        System.out.println("File Successfully Concatenated in one File");
    }

    public static void main(String[] args) {

        String folder ="C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Rohit_Java\\File_Handling_Core_Java\\src\\com\\File_Handling\\File_Con";
         fileConcat(folder);
    }
}
