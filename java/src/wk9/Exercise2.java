package wk9;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise2 {
    public void genereateSortAndPrintRandomInts(int numberOfVals, int maxValueExc) {
        IntStream numbers = new Random().ints(0,maxValueExc);

        List<Integer> values = numbers.distinct()
                .limit(numberOfVals)
                .boxed()
                .collect(Collectors.toList());

        values.sort(Comparator.reverseOrder());

        StringJoiner stringJoiner = new StringJoiner(" > ","reverse ordered list = { ", " }");
        values.forEach(n -> stringJoiner.add(n.toString()));

        System.out.println(stringJoiner);
    }

    static void main (String[] args) {
        Exercise2 ex2 = new Exercise2();
        ex2.genereateSortAndPrintRandomInts(10,150);
    }
}
