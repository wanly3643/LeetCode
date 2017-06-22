import java.util.*;
public class Solution {
    private boolean check(char[] cache) {
        Stack<Character> s = new Stack<Character>();
        s.push(cache[0]);

        for (int i = 1; i < cache.length; i ++) {
            if (s.empty()) {
                s.push(cache[i]);
            } else {
                Character peek = s.peek();
                if (peek == '(' && cache[i] == ')') {
                    s.pop();
                } else {
                    s.push(cache[i]);
                }
            }
        }

        return s.empty();
    }
    public void nextP(int left, int right, int n, char[] cache, List<String> all) {
        if (left >= n) {
            if (right < n) {
                cache[left + right] = ')';
                nextP(left, right + 1, n, cache, all);
            } else {
                if (check(cache)) {
                    all.add(new String(cache));
                }
            }
        } else if (right >= n) {
            if (left < n) {
                cache[left + right] = '(';
                nextP(left + 1, right, n, cache, all);
            } else {
                if (check(cache)) {
                    all.add(new String(cache));
                }
            }
        } else {
            cache[left + right] = '(';
            nextP(left + 1, right, n, cache, all);
            cache[left + right] = ')';
            nextP(left, right + 1, n, cache, all);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> all = new LinkedList<String>();
        if (n < 0) {
            return all;
        } else if (n == 0) {
            all.add("");
            return all;
        }

        char[] cache = new char[n * 2];
        cache[0] = '(';
        nextP(1, 0, n, cache, all);

        return all;
    }
}