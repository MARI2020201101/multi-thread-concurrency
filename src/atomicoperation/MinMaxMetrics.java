package atomicoperation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class MinMaxMetrics {

    // Add all necessary member variable
    List<AtomicLong> stocks = new ArrayList<>();
    private long min;
    private long max;

    /**
     * Initializes all member variables
     */
    public MinMaxMetrics() {
        this.min = Long.MAX_VALUE;
        this.max = Long.MIN_VALUE;
    }

    /**
     * Adds a new sample to our metrics.
     */
    public void addSample(long newSample) {
        stocks.add(new AtomicLong(newSample));
        if(min > newSample){
            min = newSample;
        }
        else if(max < newSample){
            max = newSample;
        }
    }

    /**
     * Returns the smallest sample we've seen so far.
     */
    public long getMin() {
        return min;
    }

    /**
     * Returns the biggest sample we've seen so far.
     */
    public long getMax() {
        return max;
    }
}
