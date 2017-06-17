
public class Solution {
    private boolean checkPalindrome(String s, int start, int end) {
        int i = start;
        int j = end - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i ++;
            j --;
        }

        return true;
    }
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        int len = s.length();
        int start = 0;
        int end = 0;
        int j = 0;
        for (int i = 0; i < len; i ++) {
            if (i + (end - start) >= len) {
                break;
            }

            j = len;
            for (; j > i; j --) {
                if (checkPalindrome(s, i, j)) {
                    break;
                }
            }
            if ((j - i) > (end - start)) {
                start = i;
                end = j;
            }
        }

        if (end > start) {
            return s.substring(start, end);
        } else {
            return "";
        }
    }
}