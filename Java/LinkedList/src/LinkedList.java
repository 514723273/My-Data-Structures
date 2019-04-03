public class LinkedList<E> {

    // add[0, size], remove[0, size), get[0, size), set[0, size)方法中的判断index合法性都在getNode中体现
    // 只有add范围包括size，其余操作都是针对已有元素
    private class Node {
        public E e;
        public Node next;

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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public void add(int index, E e) {
        Node prev = getNode(index - 1);

//        Node node = new Node(e, null);
//        node.next = prev.next;
//        prev.next = node;
        prev.next = new Node(e, prev.next);

        size ++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        Node prev = getNode(index - 1);

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;

        size --;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void set(int index, E e) {
        Node cur = getNode(index);
        cur.e = e;
    }

    public E get(int index) {
        return getNode(index).e;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private Node getNode(int index) {
        if(index < -1 || index >= size) {
            throw new IllegalArgumentException(String.format("getNode failed! Index[%d] arrange is [0, size)", index));
        }
        Node cur = dummyHead;
        for(int i = -1; i < index; i ++) {
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null) {
            stringBuilder.append(cur);
            stringBuilder.append("->");
            cur = cur.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}
