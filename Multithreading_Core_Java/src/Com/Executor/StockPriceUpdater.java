package Com.Executor;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StockPriceUpdater {

    private static final Map<String,Double> stockPrice = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        List<String> stocks = Arrays.asList("APPL","GOOG","TSLA");
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(stocks.size());

        Random random = new Random();

        for (String stock : stocks) {
            scheduler.scheduleAtFixedRate(() -> {
                double price = 100 + (200 * random.nextDouble());
                stockPrice.put(stock, price);
                System.out.println(LocalTime.now() + " | " + stock + ": $" + String.format("%.2f", price));
            }, 0, 3, TimeUnit.SECONDS);
        }

        Thread.sleep(10000);
        scheduler.shutdownNow();


    }
}
