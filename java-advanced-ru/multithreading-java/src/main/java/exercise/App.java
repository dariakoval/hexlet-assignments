package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        Map<String, Integer> map = new HashMap<>();
        MaxThread maxThread = new MaxThread(numbers);
        maxThread.start();
        try {
            maxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put("max", maxThread.getResult());

        MinThread minThread = new MinThread(numbers);
        minThread.start();

        try {
            minThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put("min", minThread.getResult());

        return map;
    }
    // END
}
