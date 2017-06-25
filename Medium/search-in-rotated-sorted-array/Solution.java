public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int rotatePoint = 1;
        for (; rotatePoint < nums.length; rotatePoint ++) {
            if (nums[rotatePoint] < nums[rotatePoint - 1]) {
                break;
            }
        }

        if (rotatePoint >= nums.length) {
            return bsearch(nums, 0, rotatePoint, target);
        } else {
            if (nums[rotatePoint] > target) {
                return -1;
            } else if (nums[rotatePoint] == target) {
                return rotatePoint;
            } else {
                if (nums[nums.length - 1] < target) {
                    return bsearch(nums, 0, rotatePoint, target);
                } else {
                    return bsearch(nums, rotatePoint, nums.length, target);
                }
            }
        }
    }

    public int bsearch(int[] nums, int start, int end, int target) {
        int idx = -1;
        int found = -1;
        
        while (start < end) {
            idx = (start + end) / 2;
            if (nums[idx] < target) {
                start = idx + 1;
            } else if (nums[idx] > target) {
                end  = idx;
            } else {
                found = idx;
                break;
            }
        }

        return found;
    }
}