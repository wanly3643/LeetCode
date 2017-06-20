public class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || "".equals(s) || k <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int nextEnd = 0;
        for (int i = 0; i < s.length(); ) {
            nextEnd = Math.min(i + k, s.length());
            for (int j = nextEnd - 1; j >= i; j --) {
                sb.append(s.charAt(j));
            }

            i += 2 * k;
            for (int j = nextEnd; j < Math.min(i, s.length()); j ++) {
                sb.append(s.charAt(j));
            }
        }

        return sb.toString();
    }
}