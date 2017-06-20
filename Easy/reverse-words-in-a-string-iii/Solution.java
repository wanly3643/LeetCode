public class Solution {
    public String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }

        s = s.trim();

        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            while (end < s.length() && s.charAt(end) == ' ') {
                end ++;
            }

            // preserve white spaces
            for(int i = start; i < end; i ++) {
                sb.append(s.charAt(i));
            }

            start = end;
            while (end < s.length() && s.charAt(end) != ' ') {
                end ++;
            }
            for(int i = end - 1; i >= start; i --) {
                sb.append(s.charAt(i));
            }
            start = end;
        }

        return sb.toString();
    }
}