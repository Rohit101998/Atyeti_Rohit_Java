package com.logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class File_Reader {

//    private static Map<String,Integer> log_Counts = new HashMap<>();
//    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
//
//    public void readData1(String directory_Path){
//        List<Runnable> task  = new ArrayList<>();
//        log_Counts.put("ERROR",0);
//        log_Counts.put("WARNING",0);
//        log_Counts.put("INFO",0);
//
//        File dir = new File(directory_Path);
//        File[] files = dir.listFiles((d,name)->name.endsWith(".log"));
//
//        if(files == null || files.length==0){
//            throw new LogProcessException("No log file in Directory: "+directory_Path);
//        }
//
//        for (File file:files){
//            task.add(()->ProcessFile(file));
//        }
//
//        for(Runnable ta:task){
//            executorService.submit(ta);
//        }
//        executorService.shutdown();









//            try(BufferedReader br = new BufferedReader(new FileReader(file))){
//               String line;
//                while((line = br.readLine()) != null){
//                    if(line.contains("ERROR")){
//                        log_Counts.put("ERROR",log_Counts.get("ERROR")+1);
//                    } else if (line.contains("WARNING")) {
//                        log_Counts.put("WARNING",log_Counts.get("WARNING")+1);
//                    } else if (line.contains("INFO")) {
//                        log_Counts.put("INFO",log_Counts.get("INFO")+1);
//                    }
//
//                }
//            }catch (IOException e){
//                throw new LogProcessException("Error Reading file"+file.getName());
//            }





//
//    }
//
//    private synchronized void  ProcessFile(File file){
//        try(BufferedReader br = new BufferedReader(new FileReader(file))){
//            String line;
//            while((line = br.readLine()) != null){
//                if(line.contains("ERROR")){
//
//                    log_Counts.put("ERROR",log_Counts.get("ERROR")+1);
//                } else if (line.contains("WARNING")) {
//                    log_Counts.put("WARNING",log_Counts.get("WARNING")+1);
//                } else if (line.contains("INFO")) {
//                    log_Counts.put("INFO",log_Counts.get("INFO")+1);
//                }
//
//            }
//        }catch (IOException e){
//            throw new LogProcessException("Error Reading file"+file.getName());
//        }
//    }
//
//    public Map<String,Integer> getLog_Counts(){
//        return log_Counts;
//    }

}
