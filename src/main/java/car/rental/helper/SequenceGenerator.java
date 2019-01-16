package car.rental.helper;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by erroh on 1/14/2019.
 */
public class SequenceGenerator {

    private static final AtomicInteger counter = new AtomicInteger();

    public static int getNextInt(){
        return counter.getAndIncrement();
    }
}
