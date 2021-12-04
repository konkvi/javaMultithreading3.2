import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Shop {
    private LongAdder revenue = new LongAdder();
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 50;


    public void sum() {
        IntStream.range(MIN_RANGE, MAX_RANGE)
                .forEach(i ->
                { System.out.printf("Покупка в %s на сумму %d рублей\n",Thread.currentThread().getName(), i);
                    revenue.add(i);});
    }

    public Long getRevenue() {
        return revenue.sum();
    }
}
