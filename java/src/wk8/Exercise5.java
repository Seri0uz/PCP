package wk8;

import java.util.stream.IntStream;

public class Exercise5 {

    public void countTo99 () {
        IntStream.iterate(0,n -> n + 1)
                .limit(100)
                .forEach(n -> System.out.print(n + ", "));
    }

    public void countTo99Parallel () {
        IntStream.iterate(0,n -> n + 1)
                .limit(100)
                .parallel()
                .forEach(n -> System.out.print(n + ", "));
    }
    //b)  Der parallele Stream verarbeitet die Elemente auf mehreren Threads. forEach garantiert dabei keine Ausgabereihenfolge.
    // Mit forEachOrdered kann man die Reihenfolge wieder sicherstellen

    static void main(String[] args) {
        Exercise5 ex5 = new Exercise5();
        ex5.countTo99();
        //ex5.countTo99Parallel();
    }
}
