package com.logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class File_Reader_AtomicInt {

    private static ConcurrentMap<String, AtomicInteger> log_Counts = new ConcurrentHashMap<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void readData1(String directory_Path) throws InterruptedException {
        List<Runnable> task  = new ArrayList<>();
        log_Counts.put("ERROR",new AtomicInteger(0));
        log_Counts.put("WARNING",new AtomicInteger(0));
        log_Counts.put("INFO",new AtomicInteger(0));

        File dir = new File(directory_Path);
        File[] files = dir.listFiles((d,name)->name.endsWith(".log"));

        if(files == null || files.length==0){
            throw new LogProcessException("No log file in Directory: "+directory_Path);
        }

        for (File file:files){
            task.add(()->ProcessFile(file));
        }

        for(Runnable ta:task){
            executorService.submit(ta);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);


    }

    private synchronized void  ProcessFile(File file){
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                if(line.contains("ERROR")){
                  //  log_Counts.put("ERROR",log_Counts.get("ERROR")+1);
                    log_Counts.get("ERROR").incrementAndGet();
                } else if (line.contains("WARNING")) {
                   // log_Counts.put("WARNING",log_Counts.get("WARNING")+1);
                    log_Counts.get("WARNING").incrementAndGet();
                } else if (line.contains("INFO")) {
                   // log_Counts.put("INFO",log_Counts.get("INFO")+1);
                    log_Counts.get("INFO").incrementAndGet();
                }

            }
        }catch (IOException e){
            throw new LogProcessException("Error Reading file"+file.getName());
        }
    }

    public ConcurrentMap<String,AtomicInteger> getLog_Counts(){
        return log_Counts;
    }
}
