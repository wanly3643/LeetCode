public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums cannot be empty");
        }

        int rotatePoint = nums.length - 1;
        for (; rotatePoint > 0; rotatePoint --) {
            if (nums[rotatePoint] < nums[rotatePoint - 1]) {
                break;
            }
        }

        return nums[rotatePoint];
    }
}