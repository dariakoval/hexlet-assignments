package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String str;

    public ReversedSequence(String str) {
        StringBuilder result = new StringBuilder(str);
        this.str = result.reverse().toString();
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int i) {
        return str.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return str.substring(i, i1);
    }

    public String toString() {
        return str;
    }
}
// END
