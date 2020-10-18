import java.util.*;

public class Solution {

    public List<Integer> createTriple(int n1, int n2, int n3) {
        List<Integer> one = new ArrayList<Integer>(3);
        one.add(n1);
        one.add(n2);
        one.add(n3);

        return one;
    }
    public int threeSumClosest(int[] nums, int target) {
        List<List<Integer>> all = new LinkedList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return all;
        }

        Arrays.sort(nums);
        int idx0Start = -1;
        int idx0End = -1;

        // Find if there is zero within the list
        int start = 0;
        int end = nums.length;
        int idx = -1;
        while (start < end) {
            idx = (start + end) / 2;
            if (nums[idx] < target) {
                start = idx + 1;
            } else if (nums[idx] > target) {
                end = idx;
            } else {
                idx0Start = idx0End = idx;
                break;
            }
        }

        // Check how many 0 there are
        int negativeEnd = 0;
        int postiveStart = 0;
        if (idx0End >= 0) {
            while (idx0Start > 0) {
                if (nums[idx0Start - 1] < 0) {
                    break;
                }

                idx0Start --;
            }
            while (idx0End < nums.length - 1) {
                if (nums[idx0End + 1] > 0) {
                    break;
                }

                idx0End ++;
            }

            negativeEnd = idx0Start;
            postiveStart = idx0End + 1;
        } else {
            negativeEnd = postiveStart = start;
        }

        // If there are only postive numbers or negative numbers(means cannot get 0 by sum)
        if (negativeEnd <= 0 || postiveStart >= nums.length) {
            if (idx0End - idx0Start >= 2) {
                all.add(createTriple(0, 0, 0));
            }

            return all;
        }

        // divide the array into three parts, left is negatives and right is postives, middle are 0

        // Pick two from left and one from right
        int prev = 0;
        int prev2 = 0;
        int target = 0;
        for (int i = 0; i < negativeEnd; i ++) {
            if (prev == nums[i]) {
                continue;
            }
            prev = nums[i];

            prev2 = 0;
            for (int j = i + 1; j < negativeEnd; j ++) {
                if (prev2 == nums[j]) {
                    continue;
                }

                prev2 = nums[j];
                target = 0 - (prev + prev2);
                if (bsearch(nums, postiveStart, nums.length, target)) {
                    all.add(createTriple(prev, prev2, target));
                }
            }
        }

        // Pick two from left and one from right
        prev = 0;
        for (int i = postiveStart; i < nums.length; i ++) {
            if (prev == nums[i]) {
                continue;
            }
            prev = nums[i];

            prev2 = 0;
            for (int j = i + 1; j < nums.length; j ++) {
                if (prev2 == nums[j]) {
                    continue;
                }

                prev2 = nums[j];
                target = 0 - (prev + prev2);
                if (bsearch(nums, 0, negativeEnd, target)) {
                    all.add(createTriple(target, prev, prev2));
                }
            }
        }

        // if there is zero, pick one from left and one from right, and sum with 0
        if (idx0Start > 0) {
            prev = 0;

            if (negativeEnd < (nums.length - postiveStart)) {
                for (int i = 0; i < negativeEnd; i ++) {
                    if (prev == nums[i]) {
                        continue;
                    }
                    prev = nums[i];
                    target = 0 - prev;
                    if (bsearch(nums, postiveStart, nums.length, target)) {
                        all.add(createTriple(prev, 0, target));
                    }
                }
            } else {
                for (int i = postiveStart; i < nums.length; i ++) {
                    if (prev == nums[i]) {
                        continue;
                    }
                    prev = nums[i];
                    target = 0 - prev;
                    if (bsearch(nums, 0, negativeEnd, target)) {
                        all.add(createTriple(target, 0, prev));
                    }
                }
            }
            if (idx0End - idx0Start >= 2) {
                all.add(createTriple(0, 0, 0));
            }
        }

        return all;
    }

    public boolean bsearch(int[] nums, int start, int end, int target) {
        int idx = -1;
        while (start < end) {
            idx = (start + end) / 2;
            if (nums[idx] < target) {
                start = idx + 1;
            } else if (nums[idx] > target) {
                end = idx;
            } else{
                return true;
            }
        }

        return false;
    }
}