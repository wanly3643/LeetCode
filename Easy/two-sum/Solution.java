public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = 0;
        if (nums == null || (len = nums.length) <= 0) {
            return null;
        }

        for (int i = 0; i < len; i ++) {
            for (int j = i + 1; j < len; j ++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}