package wk8;

import java.util.Random;
import java.util.stream.IntStream;

public class Exercise6 {
    public void eternalCount() {
        int[] counter = {0};
        IntStream numbers = new Random().ints();
        numbers.anyMatch(n -> {
            counter[0]++;
            if (n >= 10_000 && n <= 12_000) {
                System.out.println("random number: " + n);
                System.out.println("Found suitable number at stream position " + counter[0]);
                return true;
            }
            return false;
        });
    }

    static void main(String[] args) {
        Exercise6 ex6 = new Exercise6();
        ex6.eternalCount();
    }
}
