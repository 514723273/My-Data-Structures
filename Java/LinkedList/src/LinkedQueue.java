public class LinkedQueue<E> implements Queue<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            if(e == null) {
                return "NULL";
            } else {
                return e.toString();
            }
        }
    }

    private Node head, tail;
    private int size;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("dequeue failed! The queue is empty!");
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;

        //当只有一个元素的时候，head后移指向null，tail依旧指着该元素。
        //看似不会对入队操作（走else）有影响，但是在打印输出的时候，由于head一直处于null，无法找到下一个节点打印。
        if(head == null) {
            tail = null;
        }

        size --;

        return retNode.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedQueue: front ");

        Node cur = head;
        while(cur != null) {
            stringBuilder.append(cur);
            stringBuilder.append("->");
            cur = cur.next;
        }
        stringBuilder.append("NULL tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        for(int i = 0; i < 5; i ++) {
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
        for(int i = 0; i < 4; i ++) {
            queue.dequeue();
            System.out.println(queue);
        }
        for(int i = 0; i < 5; i ++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
    }
}
