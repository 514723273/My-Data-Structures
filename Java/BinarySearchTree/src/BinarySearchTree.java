import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author KiyonamiYu
 * @date 2019/4/5 15:23
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(Node node) {
        return node == null ? 0 : getSize(node.left) + getSize(node.right) + 1;
    }

    //二分搜索树的最大深度
    public int getMaxLevel() {
        return getMaxLevel(root);
    }

    private int getMaxLevel(Node node) {
        return node == null ? 0 : Math.max(getMaxLevel(node.left), getMaxLevel(node.right)) + 1;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if(node == null) {
            return false;
        }
        if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if(e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return true;
        }
    }

    // 二分搜索树的非递归前序遍历
    public void preOrderNR() {
        if(root == null) {
            System.out.println("NULL");
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node stackTop = stack.pop();
            System.out.println(stackTop.e);

            if(stackTop.right != null) {
                stack.push(stackTop.right);
            }
            if(stackTop.left != null) {
                stack.push(stackTop.left);
            }
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 二分搜索树的层序遍历
    public void levelOrder() {
        if(root == null) {
            System.out.println("NULL");
            return;
        }
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node queueFront = queue.remove();
            System.out.println(queueFront.e);

            if(queueFront.left != null) {
                queue.add(queueFront.left);
            }
            if(queueFront.right != null) {
                queue.add(queueFront.right);
            }
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimum() {
        if(root == null) {
            throw new IllegalArgumentException("BinarySearchTree is empty");
        }

        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if(node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum() {
        if(root == null) {
            throw new IllegalArgumentException("BinarySearchTree is empty");
        }

        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if(node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if(node == null) {
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if(e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } //else e.compareTo(node.e) == 0

        return node;
    }

    public E removeMin() {
        if(root == null) {
            throw new IllegalArgumentException("BinarySearchTree is empty");
        }
        Node ret = minimum(root);
        root = removeMin(root);
        return ret.e;
    }

    private Node removeMin(Node node) {
        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null; //断开所有链接，垃圾回收
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        if(root == null) {
            throw new IllegalArgumentException("BinarySearchTree is empty");
        }
        Node ret = maximum(root);
        root = removeMax(root);
        return ret.e;
    }

    private Node removeMax(Node node) {
        if(node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if(node == null) {
            return null;
        }
        if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if(e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            // 待删除节点左子树为空的情况
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);

            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.right = null;
            node.left = null;

            return successor;
        }
    }

    //树状打印整颗搜索二叉树
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        dealNodePrintInternal(stringBuilder, Collections.singletonList(root), 1, getMaxLevel(root));
        return stringBuilder.toString();
    }

    private void dealNodePrintInternal(StringBuilder stringBuilder, List<Node> nodes, int level, int maxLevel) {
        if(nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }
        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        generateWhitespaces(stringBuilder, firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                stringBuilder.append(node.e);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                stringBuilder.append(" ");
            }

            generateWhitespaces(stringBuilder, betweenSpaces);
        }
        stringBuilder.append("\n");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                generateWhitespaces(stringBuilder, firstSpaces - i);
                if (nodes.get(j) == null) {
                    generateWhitespaces(stringBuilder, endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null) {
                    stringBuilder.append("/");
                } else {
                    generateWhitespaces(stringBuilder, 1);
                }

                generateWhitespaces(stringBuilder, i + i - 1);

                if (nodes.get(j).right != null) {
                    stringBuilder.append("\\");
                } else {
                    generateWhitespaces(stringBuilder, 1);
                }

                generateWhitespaces(stringBuilder, endgeLines + endgeLines - i);
            }

            stringBuilder.append("\n");
        }

        dealNodePrintInternal(stringBuilder, newNodes, level + 1, maxLevel);
    }

    private void generateWhitespaces(StringBuilder stringBuilder, int count) {
        if(count <= 0) {
            return;
        }
        stringBuilder.append(" ".repeat(count));
    }

    private boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }

}
