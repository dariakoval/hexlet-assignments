package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] numbers;
    private Integer result;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        result = (Integer) min;
    }

    public Integer getResult() {
        return result;
    }
}
// END
