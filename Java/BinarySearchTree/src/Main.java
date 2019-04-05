/**
 * @author KiyonamiYu
 * @date 2019/4/5 18:01
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        bst.add(6);
        bst.add(8);

        System.out.println(bst);

        bst.remove(6);
        System.out.println("bst.remove(6) = ");
        System.out.println(bst);

        bst.remove(7);
        System.out.println("bst.remove(7) = ");
        System.out.println(bst);

        bst.remove(3);
        System.out.println("bst.remove(3) = ");
        System.out.println(bst);

        bst.removeMin();
        System.out.println(bst);

        bst.removeMax();
        System.out.println(bst);

        System.out.println("bst.contains(6) = " + bst.contains(6));

        System.out.println("bst.getMaxLevel() = " + bst.getMaxLevel());

        System.out.println("bst.getSize() = " + bst.getSize());

        System.out.println("bst.isEmpty() = " + bst.isEmpty());

        System.out.println("bst.maximum() = " + bst.maximum());

        System.out.println("bst.minimum() = " + bst.minimum());


        System.out.println();
        System.out.println("preOrder: ");
        bst.preOrder();

        System.out.println();
        System.out.println("inOrder: ");
        bst.inOrder();

        System.out.println();
        System.out.println("postOrder: ");
        bst.postOrder();

        System.out.println();
        System.out.println("levelOrder: ");
        bst.levelOrder();
    }
}
