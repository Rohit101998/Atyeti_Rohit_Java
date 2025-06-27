package Com.Executor;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LogAnalyzer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String file1="C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Rohit_Java\\Multithreading_Core_Java\\src\\Com\\Executor\\File\\log1.txt";
        String file2 = "C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Rohit_Java\\Multithreading_Core_Java\\src\\Com\\Executor\\File\\log2.txt";
        String file3 = "";
        List<String> logFile = Arrays.asList(file1, file2,file3);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<Map<String, Integer>>> futures = new ArrayList<>();

        for(String file:logFile){
            futures.add(executor.submit(()->analyzelog(file)));
        }

        Map<String,Integer> finalCount = new HashMap<>();

        for (Future<Map<String,Integer>> future:futures){
            Map<String,Integer> result = future.    get();
            result.forEach((k,v)->finalCount.merge(k,v,Integer::sum));
        }
        executor.shutdown();

        System.out.println("Final log Summery: "+finalCount);

    }

    public static Map<String,Integer> analyzelog(String filePath) {
        Map<String, Integer> map = new HashMap<>();
        map.put("INFO", 0);
        map.put("SUCCESS", 0);
        map.put("ERROR", 0);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line=reader.readLine()) != null){
                if(line.contains("INFO"))map.put("INFO",map.get("INFO")+1);
                if(line.contains("SUCCESS"))map.put("SUCCESS",map.get("SUCCESS")+1);
                if(line.contains("ERROR"))map.put("ERROR",map.get("ERROR")+1);

            }
        }catch (IOException e){
            System.out.println("Failed to read file"+filePath);
        }
        return map;
    }
}
