package com.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LogAggregator {

//    public Map<String,Integer> errorMap = new HashMap<>();
//    public Map<String,Integer> warningMap = new HashMap<>();
//    public  Map<String, Integer> successMap = new HashMap<>();

    public ConcurrentMap<String,Integer> errorMap = new ConcurrentHashMap<>();
    public ConcurrentMap<String,Integer> warningMap = new ConcurrentHashMap<>();
    public  ConcurrentMap<String, Integer> successMap = new ConcurrentHashMap<>();


    public void aggregateLogs(String directoryPath){
        File dir = new File(directoryPath);
        File[] files = dir.listFiles((d,name)->name.endsWith(".log"));

        if(files==null) return;

        for(File file: files){
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                String line;
                while ((line=br.readLine()) != null){
                    if (line.contains("ERROR")){
                        System.out.println("Found ERROR line: " + line);
                        errorMap.merge(line,1,Integer::sum);
                    } else if (line.contains("WARNING")) {
                        warningMap.merge(line,1,Integer::sum);
                    } else if (line.contains("SUCCESS")) {
                        successMap.merge(line,1,Integer::sum);
                    }
                }
            } catch (IOException e) {
                ErrorLogger.log(e);
            }
        }
    }
}
