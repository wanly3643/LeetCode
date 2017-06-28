public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return (double)1;
        }

        boolean plus = false;
        if (n < 0) {
            x = 1 / x;

            if (n == Integer.MIN_VALUE) {
                plus = true;
                n = Integer.MAX_VALUE;
            } else {
                n = 0 - n;
            }
        }

        int count = 0;
        int inc = 1;
        double mul = x;
        double ret = 1;
        while (count < n) {
            inc = 1;
            mul = x;
            while (n - inc >= count) {
                ret *= mul;
                mul *= mul;
                count += inc;
                inc += inc;
            }
        }

        if (plus) {
            ret *= x;
        }

        return ret;
    }
}