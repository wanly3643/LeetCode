public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return true;
            } else {
                return false;
            }
        }
        int rotatePoint = 1;
        for (; rotatePoint < nums.length; rotatePoint ++) {
            if (nums[rotatePoint] < nums[rotatePoint - 1]) {
                break;
            }
        }

        if (rotatePoint >= nums.length) {
            return bsearch(nums, 0, rotatePoint, target) != -1;
        } else {
            if (nums[rotatePoint] > target) {
                return false;
            } else if (nums[rotatePoint] == target) {
                return true;
            } else {
                if (nums[nums.length - 1] < target) {
                    return bsearch(nums, 0, rotatePoint, target) != -1;
                } else {
                    return bsearch(nums, rotatePoint, nums.length, target) != -1;
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