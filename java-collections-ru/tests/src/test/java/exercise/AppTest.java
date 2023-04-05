package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    List<Integer> numbers;
    @BeforeEach
    void initIntegerList() {
        this.numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    }

    @Test
    void testTake() {
        // BEGIN
        List<Integer> result = App.take(numbers, 2);
        List<Integer> rightResult = Implementations.right(numbers, 2);
        assertThat(result).isEqualTo(rightResult);
        // END
    }
}
