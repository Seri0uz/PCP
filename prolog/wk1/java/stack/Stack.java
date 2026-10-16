public class Stack<T> {
    private Element<T> head;
    private int size = 0;
    public Stack(){
        this.head = null;
    }

    public void push(Element<T> node){
        node.link(this.head);
        this.head = node;
        size++;
    }

    public Element<T> top(){
        return this.head;
    }

    public Element<T> pop() {
        if (this.head == null){
            return null;
        }
        Element<T> oldHead = this.head;
        this.head = this.head.getNext();
        size--;
        return oldHead;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return this.size;
    }

    public void print() {
        if (!isEmpty()) {
            System.out.print("print - Stack contains: ");
            for (Element<T> current = this.head; current != null; current = current.getNext()) {
                System.out.print(current);
            }
            System.out.println("top element = " + head);
        }
        else {
            System.out.println("print - Stack is empty");
        }
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }
}



//ja hier macht es sinn
//Den bestehenden Stack wird geleert ohne ein neues Objekt zu erzeugen
// Wenn man ein neuen Stack erzeugen würde, könnten Referenzen immer noch auf den alten Stack zeigen