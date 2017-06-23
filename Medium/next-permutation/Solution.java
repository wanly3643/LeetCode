public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int i = nums.length - 1;
        for (; i >= 1; i --) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }

        int swap = 0;
        if (i > 0) {
            swap = nums[i - 1];
            int pos = nums.length - 1;
            while (pos > i && nums[pos] <= swap) {
                pos --;
            }

            nums[i - 1] = nums[pos];
            nums[pos] = swap;

            for (int j = i; j < (nums.length + i) / 2; j ++) {
                swap = nums[j];
                nums[j] = nums[nums.length -1 + i - j];
                nums[nums.length -1 + i - j] = swap;
            }
        } else {
            for (int j = 0; j < nums.length / 2; j ++) {
                swap = nums[j];
                nums[j] = nums[nums.length - 1 - j];
                nums[nums.length - 1 - j] = swap;
            }
        }
    }
}