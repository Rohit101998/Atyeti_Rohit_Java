package com.logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CopyOneToAnother {

//    private static Map<String,Integer> logCounts = new HashMap<>();
//
//
//    public void writeFile(String pathDirectory1,String secondPathDirectory) {
//
//        File dir = new File(pathDirectory1);
//        File  dir2 = new File(secondPathDirectory);
//
//        File[] files = dir.listFiles((d,name)->name.endsWith(".log"));
//        File[] files1 = dir2.listFiles((d,name)->name.endsWith(".log"));
//
//        if(files == null) {
//            return;
//        }
//            for(File file:files) {
//                for (File file1 : files1) {
//                    try (BufferedReader br = new BufferedReader(new FileReader(file));
//                         FileWriter fw = new FileWriter(file1)) {
//
//                        String line;
//                        while ((line = br.readLine()) != null) {
//                            fw.write(line+"\n");
//
//                        }
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("File Copied");
//                }
//            }
//        }
}
