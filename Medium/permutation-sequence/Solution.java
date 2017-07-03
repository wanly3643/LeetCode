import java.util.*;

public class Solution {
    public String getPermutation(int n, int k) {
        if (n == 0 || k == 0) {
            return "";
        }

        int factor = 1;
        for (int i = 2; i < n; i ++) {
            factor *= i;
        }

        StringBuilder sb = new StringBuilder();

        List<Integer> left = new LinkedList<Integer>();
        for (int i = 1; i <= n; i ++) {
            left.add(i);
        }
        int size = n;
        int idx = (k - 1) / factor;

        if (idx >= size) {
            return sb.toString();
        } else {
            sb.append(left.remove(idx));
        }

        while((size = left.size()) > 0) {
            k -= idx * factor;
            factor /= size;
            idx = (k - 1) / factor;
            sb.append(left.remove(idx));
        }

        return sb.toString();
    }
}