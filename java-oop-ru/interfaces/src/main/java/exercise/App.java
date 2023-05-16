package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int n) {
        if (apartments.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> temp = apartments.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .map(Home::toString)
                .toList();

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(temp.get(i));
        }
        return result;
    }
}
// END
