import java.util.*;
public class Solution {

    private void doPermute(int[] nums, int[] cache, List<List<Integer>> all) {
        int len = nums.length;
        if (nums.length <= 0) {
            List<Integer> item = new ArrayList<Integer>(cache.length);
            for (int c : cache) {
                item.add(c);
            }
            all.add(item);
            return;
        }

        int pos = cache.length - nums.length;
        int[] next = new int[len - 1];
        for (int i = 0; i < nums.length; i ++) {
            cache[pos] = nums[i];

            // Copy the rest as new array
            for (int j = 0; j < i; j ++) {
                next[j] = nums[j];
            }
            for (int j = i + 1; j < len; j ++) {
                next[j - 1] = nums[j];
            }
            doPermute(next, cache, all);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all = new LinkedList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return all;
        }

        int[] cache = new int[nums.length];
        doPermute(nums, cache, all);

        return all;
    }
}