package com.File_Handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File_Handing {
    public static void main(String[] args) {
/*
        // Code to create new file

        File myfile1 = new File("rohit.txt");
        try {
            myfile1.createNewFile();
        } catch (IOException e) {
            System.out.println("Unable to create this file");
            e.printStackTrace();
        }

        //Code to write a file

        try {
            FileWriter fileWriter = new FileWriter("rohit.txt");
            fileWriter.write("This is our first file from this java course \n OK now by");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading a file

         File myfile = new File("rohit.txt");
        try{
            Scanner sc = new Scanner(myfile);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
 */
        // Delete File

        File myfile2 = new File("rohit.txt");
        if(myfile2.delete()){
            System.out.println("I have delete:" + myfile2.getName());
        }
        else {
            System.out.println("some problem occurred while deleting the file ");
        }


    }
}
