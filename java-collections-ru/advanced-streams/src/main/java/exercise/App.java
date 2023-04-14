package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String content) {
        String[] stringArray = content.split("\n");
        List<String> list = Arrays.stream(stringArray)
                .filter(item -> item.startsWith("environment="))
                .map(item -> item.replaceAll("environment=", ""))
                .map(item -> item.replaceAll("\"", ""))
                .flatMap(item -> Stream.of(item.split(",")))
                .filter(item -> item.startsWith("X_FORWARDED_"))
                .map(item -> item.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.toList());

        return String.join(",", list);
    }
}
//END
