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

                char stackTop = arrayStack.pop();
                if(c == ')' && stackTop != '(') {
                    return false;
                } else if(c == ']' && stackTop != '[') {
                    return false;
                } else if(c == '}' && stackTop != '{') {
                    return false;
                }
            }
        }
        return arrayStack.isEmpty();
    }
}
