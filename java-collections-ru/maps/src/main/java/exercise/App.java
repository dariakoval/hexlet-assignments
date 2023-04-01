package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        if (sentence.equals("")) {
            return new HashMap<>();
        }

        String[] words = sentence.split(" ");
        List<String> uniqueWords = new ArrayList<>();
        Map<String, Integer> wordsCount = new HashMap<>();

        for (String word: words) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
            }
        }
        int count = 1;
        for (String element : uniqueWords) {
            for (String word: words) {
                if (element.equals(word)) {
                    wordsCount.put(word, count);
                    count++;
                }
            }
            count = 1;
        }
        return wordsCount;
    }
    public static String toString(Map wordsCount) {
        if (wordsCount.size() == 0) {
            return "{}";
        }

        StringBuilder result = new StringBuilder("{");
        for (Object key : wordsCount.keySet()) {
            result.append("\n  ").append(key).append(": ").append(wordsCount.get(key));
        }
        result.append("\n}");
        return result.toString();
    }
}
//END
