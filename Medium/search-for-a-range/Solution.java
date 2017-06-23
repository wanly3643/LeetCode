public class Solution {
    public int doSearch(int[] nums, int start, int end, int target, boolean leftRight) {
        if (start >= end) {
            return -1;
        }

        int idx = -1;
        boolean found = false;
        do {
            idx = (start + end) / 2;
            if (nums[idx] > target) {
                end = idx;
            } else if (nums[idx] < target) {
                start = idx + 1;
            } else {
                found = true;
                break;
            }
        } while (start < end);

        if (found) {
            int newIdx = -1;
            
            if (leftRight) { // Left
                newIdx = doSearch(nums, start, idx, target, true);
                if (newIdx != -1) {
                    idx = newIdx;
                }
            } else { // Right
                newIdx = doSearch(nums, idx + 1, end, target, false);
                if (newIdx > idx) {
                    idx = newIdx;
                }
            }

            return idx;
        } else {
            return -1;
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }

        int start = 0;
        int end = nums.length;
        int idx = -1;
        boolean found = false;
        do {
            idx = (start + end) / 2;
            if (nums[idx] > target) {
                end =  idx;
            } else if (nums[idx] < target) {
                start = idx + 1;
            } else {
                found = true;
                break;
            }
        } while (start < end);

        if (found) {
            int leftIdx = doSearch(nums, 0, idx, target, true);
            int rightIdx = doSearch(nums, idx + 1, nums.length, target, false);

            int[] ret = new int[2];
            if (leftIdx != -1) {
                ret[0] = leftIdx;
            } else {
                ret[0] = idx;
            }

            if (rightIdx != -1) {
                ret[1] = rightIdx;
            } else {
                ret[1] = idx;
            }

            return ret;
        } else {
            return new int[]{-1, -1};
        }

    }
}