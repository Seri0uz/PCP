package wk9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Exercise1 {

    public Optional<String> reduceAndPrintStrings(String[] namesArray) {
        List<String> names = Arrays.asList(namesArray);
        Optional<String> x = names
                .stream()
                .filter(s -> s.startsWith("T"))
                .map(String::toUpperCase)
                .reduce((s, t) -> s + " " + t);
        x.ifPresent(n -> System.out.println("[Debugoutput] x = " + n));
        return x;
    }

    public void printOptional(Optional<String> optionalString, String defaultValue) {
        System.out.println("value " + optionalString.orElse(defaultValue));
    }

    static void main (String[] args) {
        Exercise1 ex1 = new Exercise1();
        ex1.reduceAndPrintStrings(new String[]{"Joe", "Tara", "Sue", "Tim"});
        ex1.printOptional(ex1.reduceAndPrintStrings((new String[]{"Joe", "Lara", "Sue", "Simon"})),"Hans");

        // Man kann besser mit keinen Ergebnissen umgehen. Reduce würde sonst Null zurückgeben was evtl eine NPE auslösen kann
        // So gibt es ein Optional.Empty zurück
    }

}
