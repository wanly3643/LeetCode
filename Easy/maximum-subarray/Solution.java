class Solution {
    public int maxSubArray(int[] nums) {
        int start = -1;
        int end = nums.length;
        int i = start + 1;
        int j = end - 1;
        int sum = 0;
        int min = 0;

        while (i < j) {
            if (nums[i] < nums[j]) {
                sum += nums[i];

                if (sum <= min) {
                    min = sum;
                    start = i;
                }
                i ++;
            } else {
                sum += nums[j];

                if (sum <= min) {
                    min = sum;
                    end = j;
                }
                j --;
            }
        }

        System.out.println(start + "-" + end);
        
        int maxSum = 0;
        for (i = start + 1; i < end; i ++) {
            maxSum += nums[i];
        }

        return maxSum;
    }
}