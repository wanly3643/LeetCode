public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int max = 0;
        if (height[0] < height[height.length - 1]) {
            max = height[0] * (height.length - 1);
            for (int i = 0; i < height.length; i ++) {
                for (int j = height.length - 1; j > i; j --) {
                    max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
                    if (height[j] >= height[i]) {
                        break;
                    }
                }
            }
        } else {
            max = height[height.length - 1] * (height.length - 1);
            for (int i = height.length - 1; i > -1; i --) {
                for (int j = 0; j < i; j ++) {
                    max = Math.max(max, Math.min(height[i], height[j]) * (i - j));
                    if (height[j] >= height[i]) {
                        break;
                    }
                }
            }
        }

        return max;
    }
}