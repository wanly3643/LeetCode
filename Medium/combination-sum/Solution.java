import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // First sort as ascending
        Arrays.sort(candidates);

        List<List<Integer>> all = new LinkedList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return all;
        }

        int[] cache = new int[3];
        doComb(candidates, 0, candidates.length, cache, target, all);
        if (targetIdx != -1) {
            List<Integer> i = new ArrayList<Integer>(1);
            i.add(target);
            all.add(i);
        }

        return all;
    }

    public int doSum(List<Integer> cache) {
        int sum = 0;
        for (Integer i : cache) {
            sum += i;
        }

        return sum;
    }

    public void doComb(int[] candidates, int start, int end, List<Integer> cache, int target, List<List<Integer>> all) {
        int sum = 0;

        for (int i = start; i < end; i ++) {
            cache.add(candidates[i]);

            sum = doSum(cache);
            if (sum == target) {
                all.add(new LinkedList<Integer>(cache));
                cache.remove(cache.size() - 1);
                return;
            } else if (sum > target) {
                cache.remove(cache.size() - 1);
                return;
            } else {
                doComb(candidates, i, end, cache, target, all);
                cache.remove(cache.size() - 1);
            }
        }
    }
}