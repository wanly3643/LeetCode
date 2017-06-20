public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        boolean ended = false;
        int endIdx = 0;
        char c = 0;
        while (endIdx < strs[0].length()) {
            c = strs[0].charAt(endIdx);
            for (int i = 1; i < strs.length; i ++) {
                if (endIdx >= strs[i].length() || strs[i].charAt(endIdx) != c) {
                    ended = true;
                    break;
                }
            }

            if (ended) {
                break;
            }

            endIdx ++;
        }

        return strs[0].substring(0, endIdx);
    }
}