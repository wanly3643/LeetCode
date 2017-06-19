public class Solution {
    public int myAtoi(String str) {
        long ret = 0;
        if (str == null) {
            return 0;
        }

        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }

        int start = 0;
        boolean isMinus = false;
        if (str.charAt(0) == '-' ) {
            start = 1;
            isMinus = true;
        } else if (str.charAt(0) == '+') {
            start = 1;
        }

        // Find the max valid substring
        int validEnd = start;
        int[] digits = new int[str.length()];
        int v = 0;
        while (validEnd < str.length()) {
            if ((v = char2Int(str.charAt(validEnd))) == -1) {
                break;
            } else {
                digits[validEnd ++] = v;
            }
        }

        if (validEnd - start > 10) {// Out of range
            if (isMinus) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        long mul = 1;
        for (validEnd = validEnd - 1; validEnd >= start; validEnd --) {
            ret += mul * digits[validEnd];
            mul *= 10;
        }

        if (isMinus) {
            ret = 0 - ret;
            if (ret < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        } else {
            if (ret > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        return (int)ret;
    }

    private int char2Int(char c) {
        // return -1 if it is not valid
        int v = c - '0';
        if (v > 9 || v < 0) {
            return -1;
        } else {
            return v;
        }
    }
}