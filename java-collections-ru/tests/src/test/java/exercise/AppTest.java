package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> result1 = App.take(numbers1, 2);
        assertThat(result1).isEqualTo(expected1);

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> result2 = App.take(numbers2, 7);
        assertThat(result2).isEqualTo(expected2);

        List<Integer> numbers3 = new ArrayList<>();
        List<Integer> expected3 = new ArrayList<>();
        List<Integer> result3 = App.take(numbers3, 4);
        assertThat(result3).isEqualTo(expected3);
        // END
    }
}
