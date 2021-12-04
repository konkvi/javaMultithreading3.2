import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final Shop shop = new Shop();
        final long TIMEOUT = 2;

        final ExecutorService shopPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        shopPool.submit(shop::sum);
        shopPool.submit(shop::sum);
        shopPool.submit(shop::sum);

        try{
            shopPool.awaitTermination(TIMEOUT, TimeUnit.SECONDS);
            System.out.println("Общая выручка = " + shop.getRevenue() + " рублей");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        shopPool.shutdown();
    }

}
