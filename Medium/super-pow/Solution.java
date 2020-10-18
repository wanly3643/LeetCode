import java.math.BigInteger;

public class Solution {
    public int superPow(int a, int[] b) {
        if (a == 1) {
            return 1;
        }

        if (b.length == 0) {
            return 1;
        }

        int mod = 1337;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i ++) {
            sb.append(b[i] + "");
        }

        a = a % mod;
        BigInteger n = new BigInteger(sb.toString());
        BigInteger count = BigInteger.ZERO;
        BigInteger inc = BigInteger.ONE;
        int mul = a;
        int ret = 1;
        while (count.compareTo(n) < 0) {
            inc = BigInteger.ONE;
            mul = a;
            while (count.add(inc).compareTo(n) <= 0) {
                ret = (ret * mul) % mod;
                mul = (mul * mul) % mod;
                count = count.add(inc);
                inc = inc.add(inc);
            }
        }

        return ret;
    }
}