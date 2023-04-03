package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(java.util.List<Map<String, String>> books, Map<String,
            String> where) {
        java.util.List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book: books) {
            int count = 0;
            for (Object valueWhere: where.values()) {
                if (book.containsValue(valueWhere)) {
                    count++;
                }
            }
            if (count == where.size()) {
                result.add(book);
            }
        }
        return result;
    }
}
//END
