public class Main {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        for(int i = 0; i < 10; i ++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        System.out.println(arrayStack.peek());

        arrayStack.pop();
        System.out.println(arrayStack);

        arrayStack.pop();
        System.out.println(arrayStack);

        System.out.println((new Solution()).isValid("(})"));
        System.out.println((new Solution()).isValid("({{}}[]}()"));
    }
}
