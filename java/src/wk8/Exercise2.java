package wk8;

import java.util.Arrays;

public class Exercise2 {
    public void printNumbersAndSquares(Integer[] numbers) {
        Arrays.asList(numbers).forEach(number -> System.out.println(number +": " + (number * number) ));
    }
    public static void main(String[] args) {
    Exercise2 ex2 = new Exercise2();
    ex2.printNumbersAndSquares(new Integer[]{1,2,3,5,8});
    }
}
