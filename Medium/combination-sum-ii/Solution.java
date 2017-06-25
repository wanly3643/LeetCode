import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // First sort as ascending
        Arrays.sort(candidates);

        List<List<Integer>> all = new LinkedList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return all;
        }

        // Find the taget
        int start = 0;
        int end = candidates.length;
        int idx = -1;
        int targetIdx = -1;
        while (start < end) {
            idx = (start + end) / 2;
            if (candidates[idx] < target) {
                start = idx + 1;
            } else if (candidates[idx] > target) {
                end = idx;
            } else {
                targetIdx = idx;
                break;
            }
        }

        int max = start;
        if (targetIdx != -1) {
            int j = targetIdx - 1;
            for (; j >= 0; j --) {
                if (candidates[j] != target) {
                    break;
                }
            }
            targetIdx = j + 1;
            max = j + 1;
        }

        if (max < 1) {
            if (targetIdx != -1) {
                List<Integer> i = new ArrayList<Integer>(1);
                i.add(target);
                all.add(i);
            }

            return all;
        }

        List<Integer> cache  = new LinkedList<Integer>();
        doComb(candidates, 0, max, cache, target, all);
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
        int prev = -1;

        for (int i = start; i < end; i ++) {
            if (prev == candidates[i]) {
                continue;
            }
            prev = candidates[i];
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
                doComb(candidates, i + 1, end, cache, target, all);
                cache.remove(cache.size() - 1);
            }
        }
    }
}