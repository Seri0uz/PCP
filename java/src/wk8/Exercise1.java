package wk8;

public class Exercise1 implements GeneralInterface, SpecificInterface {
    public static void main(String[] args) {
        Exercise1 ex1 = new Exercise1();
        ex1.doIt();
    }
}

// a)
// Do it the SPECIFIC way.


//b)
// Weil SpecificInterface vom Generalinterface erbt und somit dessen Methode überschreibt

//c)
// Nein, es ist sogar redundant. Durch implements SpecificInterface implementiert Exercise1 auch GeneralInterface