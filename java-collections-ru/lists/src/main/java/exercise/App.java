package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        if (symbols.length() < word.length()) {
            return false;
        }

        String normalizedWord = word.toLowerCase();
        String[] symbolsArr = symbols.split("");
        String[] wordArr = normalizedWord.split("");

        List<String> symbolsList = new ArrayList<>();
        Collections.addAll(symbolsList, symbolsArr);
        int count = 0;
        for (String element: wordArr) {
            for (String symbol: symbolsList) {
                if (element.equals(symbol)) {
                    symbolsList.remove(symbol);
                    count++;
                    break;
                }
            }
        }
        return count == wordArr.length;
    }
}
//END
