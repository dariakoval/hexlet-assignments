package exercise;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> input) {
        long result1 = input.stream()
                .filter(email -> StringUtils.endsWithIgnoreCase(email, "gmail.com"))
                .count();
        long result2 = input.stream()
                .filter(email -> StringUtils.endsWithIgnoreCase(email, "yandex.ru"))
                .count();
        long result3 = input.stream()
                .filter(email -> StringUtils.endsWithIgnoreCase(email, "hotmail.com"))
                .count();
        return result1 + result2 + result3;
    }
}
// END
