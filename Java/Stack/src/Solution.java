public class Solution {
    public boolean isValid(String s) {
        ArrayStack<Character> arrayStack = new ArrayStack<>();
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                arrayStack.push(c);
            } else {
                if(arrayStack.isEmpty()) {
                    return false;
                }

                char stackTop = arrayStack.peek();
                if(c == ')' && stackTop == '(') {
                    arrayStack.pop();
                } else if(c == ']' && stackTop == '[') {
                    arrayStack.pop();
                } else if(c == '}' && stackTop == '{') {
                    arrayStack.pop();
                } else {
                    arrayStack.push(c);
                }
            }
        }
        return arrayStack.isEmpty();
    }
}
