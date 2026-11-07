package wk8;

import java.util.Optional;
import java.util.stream.Stream;

public class Exercise4 {
    public String processNames(String[] names) {
       return Stream.of(names)
                .filter(s -> s.length() > 2 && s.length() < 5)
                .map(String::toUpperCase)
                .reduce((s, t) -> s + " " + t)
                .orElse("");
    }

    static void main(String[] args) {
        Exercise4 ex4 = new Exercise4();
        System.out.println(ex4.processNames(new String[] {"Susanna", "Joe", "Lu", "Timmy", "Rafael", "Lisa"} ));
    }
}
