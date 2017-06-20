import java.util.List;
import java.util.LinkedList;

public class Solution {
    char[][] chars = new char[][] {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
        
    };
    public void appendChar(String s, int idx, StringBuilder cache, List<String> all) {
        if (idx >= s.length()) {
            all.add(cache.toString());
            return;
        }

        char c = 0;
        while ((c = s.charAt(idx)) > '9' || c < '2') { // Skip invalid
            if ((++ idx) >= s.length()) {
                break;
            }
        }

        if (idx >= s.length()) { // Reach the end
            all.add(cache.toString());
            return;
        } else {
            int charIdx = c - '2';
            if (charIdx > -1 && charIdx < chars.length) {
                for (char possible : chars[charIdx]) {
                    cache.append(possible);
                    appendChar(s, idx + 1, cache, all);
                    cache.deleteCharAt(cache.length() - 1); // delete last and use again.
                }
            } else {
                throw new RuntimeException("Cannot be here");
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> all = new LinkedList<String>();
        if (digits == null || "".equals(digits)) {
            return all;
        }

        // Skip all starting 0 and 1
        StringBuilder sb = new StringBuilder();
        appendChar(digits, 0, sb, all);

        return all;
    }
}