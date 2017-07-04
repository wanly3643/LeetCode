public class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[] {0, 0, 0};
        int color = 0;
        for (int i = 0; i < nums.length; i ++) {
            color = nums[i];
            count[color] = count[color] + 1;
        }

        // Reset
        int offset = 0;
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < count[i]; j ++) {
                nums[offset + j] = i;
            }

            offset += count[i];
        }
    }
}