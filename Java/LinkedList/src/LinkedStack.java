public class LinkedStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack: top ");
        stringBuilder.append(linkedList.toString());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();

        for(int i = 0; i < 3; i ++) {
            linkedStack.push(i);
            System.out.println(linkedStack);
        }
        System.out.println(linkedStack.peek());

        linkedStack.pop();
        System.out.println(linkedStack);

        linkedStack.pop();
        System.out.println(linkedStack);

    }
}
