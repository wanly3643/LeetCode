/**
 * 考虑各种边界条件
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("/ by zero");
        }

        if (divisor == 1 || dividend == 0) {
            return dividend;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == divisor) {
            return 1;
        }

        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }

        int HALF_MAX_INT = 1073741823;

        boolean negative = false;
        int count = 0;
        int inc = 1;
        int divisor2 = 0;
        if (dividend < 0) {
            if (divisor < 0) {
                divisor = 0 - divisor;
            } else {
                negative = true;
            }

            while (dividend <= 0 && dividend + divisor <= 0) {
                divisor2 = divisor;
                inc = 1;
                while (dividend <= 0 && dividend + divisor2 <= 0) {
                    dividend += divisor2;
                    count += inc;

                    if (divisor2 > HALF_MAX_INT) {
                        break;
                    }
                    divisor2 += divisor2;
                    inc += inc;
                }
            }
        } else {
            if (divisor < 0) {
                divisor = 0 - divisor;
                negative = true;
            }

            while (dividend >= 0 && dividend - divisor >= 0) {
                divisor2 = divisor;
                inc = 1;
                while (dividend >= 0 && dividend - divisor2 >= 0) {
                    dividend -= divisor2;
                    count += inc;

                    if (divisor2 > HALF_MAX_INT) {
                        break;
                    }
                    divisor2 += divisor2;
                    inc += inc;
                }
            }
        }

        if (negative) {
            count = 0 - count;
        }

        return count;
    }
}