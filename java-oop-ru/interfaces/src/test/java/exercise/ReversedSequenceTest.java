package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReversedSequenceTest {
    CharSequence text;
    @BeforeEach
    void initObject() {
        this.text = new ReversedSequence("abcdef");
    }
    @Test
    void testToString() {
        String result = text.toString();
        assertThat(result).isEqualTo("fedcba");
    }
    @Test
    void testCharAt() {
        char result = text.charAt(1);
        assertThat(result).isEqualTo('e');
    }
    @Test
    void testLength() {
        int result = text.length();
        assertThat(result).isEqualTo(6);
    }
    @Test
    void testSubSequence() {
        String result = text.subSequence(1, 4).toString();
        assertThat(result).isEqualTo("edc");
    }
}
