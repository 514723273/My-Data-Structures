/**
 * @author KiyonamiYu
 * @date 2019/4/11 13:58
 */
public class LinkedSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    public LinkedSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if(!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public E[] toArray() {
        E[] result = (E[])new Object[getSize()];
        for(int i = 0; i < getSize(); i ++) {
            result[i] = linkedList.get(i);
        }
        return result;
    }
}
