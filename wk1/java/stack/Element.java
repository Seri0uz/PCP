import java.util.Objects;

public class Element<T> {
    private final T value;
    private Element<T> nextValue;

    public Element(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void link(Element<T> next){
        this.nextValue = next;
    }

    public Element<T> getNext() {
        return nextValue;
    }

    @Override
    public String toString() {
        return value + " ";
    }
}