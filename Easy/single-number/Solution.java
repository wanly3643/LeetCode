class Solution {
    public int singleNumber(int[] nums) {
        // Use Xor
        int result = 0;
        for (int i : nums) {
            result = result ^ i;
        }

        return result;
    }
}