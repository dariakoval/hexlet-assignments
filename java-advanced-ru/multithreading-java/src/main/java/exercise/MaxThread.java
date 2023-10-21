package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] numbers;
    private Integer result;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        result = (Integer) max;
    }

    public Integer getResult() {
        return result;
    }
}
// END
