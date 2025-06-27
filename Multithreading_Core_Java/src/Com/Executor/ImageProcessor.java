package Com.Executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ImageProcessor {
    public static void main(String[] args) {

        List<String> images= Arrays.asList("img1.jpg","img2.jpg","img3.jpg","img4.jpg","img5.jpg");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(String image:images){
            executor.submit(()->ProcessImage(image));
        }
        executor.shutdown();

        try{
            if(!executor.awaitTermination(60, TimeUnit.SECONDS)){
                executor.shutdown();
            }
        }catch (InterruptedException e){
            executor.shutdown();
        }

    }
    public static void ProcessImage(String image){
        try {
            System.out.println("Compressing "+image + " on "+ Thread.currentThread().getName());
            Thread.sleep(1000);

            System.out.println("Watermarking "+ image+ " on " +Thread.currentThread().getName());
            Thread.sleep(1000);

            System.out.println("Saving "+image+" on "+Thread.currentThread().getName());
            Thread.sleep(1000);

            System.out.println("Finished "+image+" on "+Thread.currentThread().getName());
        }catch (InterruptedException e){
            System.out.println("Task interrupted for image"+image);
            Thread.currentThread().interrupt();
        }

    }
}
