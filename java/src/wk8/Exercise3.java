package wk8;

public class Exercise3{
    static void main(String[] args) {
        TripleIntOperator tio = (a,b,c) -> a + b + c;
        System.out.println(tio.applyAsInt(3,6,8));
    }
}

//b)
// int