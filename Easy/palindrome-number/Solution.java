public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int digits = 1;
        int t = x;
        while (t >= 10) {
            digits *= 10;
            t /= 10;
        }

        int i = 1;
        while (i < digits) {
            if ((x / i) % 10 != (x / digits) % 10) {
                return false;
            }

            i *= 10;
            digits /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPalindrome(Integer.MAX_VALUE) + "\n\n");
    }
}