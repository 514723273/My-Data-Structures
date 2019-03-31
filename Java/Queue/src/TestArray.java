public class TestArray {

    private static Array<Integer> array = new Array<>(10);

    public static void main(String[] args) {
        //TEST array.addLast
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        testPrint("array.addLast(0~9)");

        //TEST array.contains
        testPrint("array.contains(0) = " + array.contains(0));
        testPrint("array.contains(10) = " + array.contains(10));

        //TEST array.find
        testPrint("array.find(0) = " + array.find(0));
        testPrint("array.find(5) = " + array.find(5));
        testPrint("array.find(10) = " + array.find(10));

        //TEST array.find
        testPrint("array.get(0) = " + array.get(0));
        testPrint("array.get(5) = " + array.get(5));
        try {
            testPrint("array.get(10) = " + array.get(10));
        } catch (IllegalArgumentException e) {
            System.out.println("TEST : " + "array.get(10)");
            System.out.println(e);
            System.out.print("\n");
        }

        //TEST array.isEmpty
        testPrint("array.isEmpty() = " + array.isEmpty());

        //TEST array.remove
        array.remove(9);
        array.remove(8);
        array.remove(6);
        array.remove(3);
        array.remove(2);
        testPrint("array.remove(2, 3, 6, 8, 9)");

        //TEST array.removeFirst
        array.removeFirst();
        array.removeFirst();
        testPrint("array.removeFirst() * 2");

        //TEST array.removeLast
        array.removeLast();
        testPrint("array.removeLast() & array.changeCapacity()");

        array.removeLast();
        testPrint("array.removeLast() & array.changeCapacity()");

        array.removeLast();
        testPrint("array.removeLast() & array.changeCapacity()");

        //TEST array.addFirst
        array.addFirst(0);
        testPrint("array.addFirst(0) & array.changeCapacity()");

        array.addFirst(1);
        testPrint("array.addFirst(1) & array.changeCapacity()");

        array.addFirst(2);
        testPrint("array.addFirst(2) & array.changeCapacity()");

        //TEST array.set
        array.set(0, -2);
        testPrint("array.set(0, -2)");
    }

    private static void testPrint(String testTittle) {
        System.out.println("TEST : " + testTittle);
        System.out.println(array);
    }
}
