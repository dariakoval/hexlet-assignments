package exercise;

import java.util.Map;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> data = storage.toMap();
        for (String key: data.keySet()) {
            storage.unset(key);
            storage.set(data.get(key), key);
        }
    }
}
// END
