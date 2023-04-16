package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new HashMap<>();
        if (data1.size() == 0) {
            for (String key: data2.keySet()) {
             result.put(key, "added")   ;
            }
        } else if (data2.size() == 0) {
            for (String kye: data1.keySet()) {
                result.put(kye, "deleted");
            }
        } else {
            for (String key1 : data1.keySet()) {
                for (String kye2 : data2.keySet()) {
                    if (!data1.containsKey(kye2)) {
                        result.put(kye2, "added");
                    } else if (!data2.containsKey(key1)) {
                        result.put(key1, "deleted");
                    } else if (data2.containsKey(key1) && !data2.get(kye2).equals(data1.get(key1))) {
                        result.put(kye2, "changed");
                    } else if (data2.containsKey(key1) && data2.get(kye2).equals(data1.get(key1))) {
                        result.put(kye2, "unchanged");
                    }
                }
            }
            for (String key1 : data1.keySet()) {
                for (String kye2 : data2.keySet()) {
                    if (!data2.containsKey(key1)) {
                        result.put(key1, "deleted");
                    } else if (!data1.containsKey(kye2)) {
                        result.put(kye2, "added");
                    } else if (data2.containsKey(key1) && !data2.get(kye2).equals(data1.get(key1))) {
                        result.put(kye2, "changed");
                    } else if (data2.containsKey(key1) && data2.get(kye2).equals(data1.get(key1))) {
                        result.put(kye2, "unchanged");
                    }
                }
            }
        }
        return result.entrySet()
                .parallelStream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
    }
}
//END
