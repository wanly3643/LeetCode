import java.util.*;
public class Solution {
    private boolean compare(char c1, char c2) {
        return (c1 == '(' && c2 == ')') 
            || (c1 == '{' && c2 == '}')
            || (c1 == '[' && c2 == ']');
    }
    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        
        Stack<Character> stack = new Stack<Character>();
        char c = 0;
        for (int i = 0; i < s.length(); i ++) {
            c = s.charAt(i);
            if (stack.empty()) {
                stack.push(c);
            } else {
                Character peek = stack.peek();
                if (compare(peek, c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.empty();
    }
}