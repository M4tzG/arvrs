package extra;

import java.text.DecimalFormat;

public class PerformanceTest {
    public PerformanceTest() {}
    public long measure(Callback callback) {
        long startTime = System.nanoTime();
        callback.onCallback();
        long endTime = System.nanoTime();
        long res = (long) endTime - startTime;
        double seconds = (double) res / 1e9;
        System.out.println(
                "Function executed in "
                + new DecimalFormat("0.##########").format(seconds)
                + " seconds.\n"
        );
        return (long) res;
    }
}
