public class Solution {
    public int reverse(int x) {
        char[] digits = String.valueOf(x).toCharArray();
        StringBuilder sb = new StringBuilder();
        int first = 0;
        if (digits[0] == '-') {
            sb.append("-");
            first = 1;
        }
        for (int i = digits.length - 1; i >= first; i --) {
            sb.append(digits[i]);
        }

        long l = Long.parseLong(sb.toString());

        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int)l;
        }
    }
}