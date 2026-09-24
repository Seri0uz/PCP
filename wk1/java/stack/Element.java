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

    public boolean hasNext() {
        return nextValue != null;
    }

    @Override
    public String toString() {
        return value + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        return (o instanceof Element Element)
                && Objects.equals(this.value, Element.value);

    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}