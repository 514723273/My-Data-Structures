public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    //用户期望容积为capacity，而底层需要浪费一个空间
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front) {
            changeCapacity(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E ret = data[front];

        data[front] = null;
        front = (front + 1) % data.length;
        size --;

        if(size == getCapacity() / 4) {
            changeCapacity(getCapacity() / 2);
        }

        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Queue = { ['size'] = %d, ['capacity'] = %d}\n", size, getCapacity()));
        stringBuilder.append("front [");
        for(int i = front; i != tail; i = (i + 1) % data.length) {
            stringBuilder.append(data[i]);
            if((i + 1) % data.length != tail) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    private void changeCapacity(int newCapacity) {
        if(newCapacity < size) {
            return;
        }
        E[] newData = (E[]) new Object[newCapacity + 1];
        for(int i = 0; i < size; i ++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
}
