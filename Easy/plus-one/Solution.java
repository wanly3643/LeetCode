class Solution {
    public int[] plusOne(int[] digits) {
        int[] ret = new int[digits.length];
        int plus = 1;

        int i = digits.length - 1;
        for(; i >= 0; i --) {
            ret[i] = digits[i] + plus;

            if (ret[i] == 10) {
                ret[i] = 0;
                plus = 1;
            } else {
                plus = 0;
                break;
            }
        }

        if (plus > 0) {
            int[] newRet = new int[ret.length + 1];
            newRet[0] = 1;
            System.arraycopy(ret, 0, newRet, 1, ret.length);
            return newRet;
        } else {
            System.arraycopy(digits, 0, ret, 0, i);
            return ret;
        }
    }
}