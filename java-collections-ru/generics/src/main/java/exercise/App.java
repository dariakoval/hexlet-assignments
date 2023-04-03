package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book: books) {
            boolean find = true;
            for (Map.Entry<String, String> entry: where.entrySet()) {
                String bookValue = book.get(entry.getKey());
                if (!bookValue.equals(entry.getValue())) {
                    find = false;
                }
            }
            if (find) {
                result.add(book);
            }
        }
        return result;
    }
}
//END
