class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x; 
        }

        int base = 0;
        int m1 = 1;
        int max = 46340; // To prevent exceed the max value of integer
        int cmp = (base + m1);

        int tmp = 0;
        while (true) {
            cmp = (base + m1);
            if (max < cmp) {
                if (m1 == 1) {
                    break;
                }
                base += m1 / 2;
                m1 = 1;
            } else {
                tmp = (base + m1) * (base + m1);
                if (tmp < x) {
                    m1 *= 2;
                } else if (tmp == x) {
                    return (base + m1);
                } else {
                    if (m1 == 1) {
                        break;
                    }
                    base += m1 / 2;
                    m1 = 1;
                }
            }
        }

        return base;
    }
}