public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[])new Object[capacity];
    }

    public Array() {
        this(10);
    }

    public void add(int index, E e) {
        if(index > size || index < 0) {
            throw new IllegalArgumentException(String.format("Index is illegal! [0, %d]", size));
        }
        if(size == data.length) {
            changeCapacity(size * 2);
        }
        for(int i = size; i > index; i --) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size ++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        if(index >= size || index < 0) {
            throw new IllegalArgumentException(String.format("Index is illegal! [0, %d)", size));
        }

        E ret = data[index];

        for(int i = index; i < size - 1; i ++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size --;

        if(size == data.length / 4) {
            changeCapacity(data.length / 2);
        }

        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void set(int index, E e) {
        if(index >= size || index < 0) {
            throw new IllegalArgumentException(String.format("Index is illegal! [0, %d)", size));
        }
        data[index] = e;
    }

    public E get(int index) {
        if(index >= size || index < 0) {
            throw new IllegalArgumentException(String.format("Index is illegal! [0, %d)", size));
        }
        return data[index];
    }

    public int find(E e) {
        for(int i = 0; i < size; i ++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    public boolean contains(E e) {
        return find(e) >= 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array = {\n" +
                "\t['size'] = %d,\n" +
                "\t['capacity'] = %d,\n", size, data.length));
        stringBuilder.append("\t['data'] = [");
        for(int i = 0; i < size; i ++) {
            stringBuilder.append(data[i]);
            if(i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]\n");
        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }

    private void changeCapacity(int newCapacity) {
        if(newCapacity < size) {
            return;
        }
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
