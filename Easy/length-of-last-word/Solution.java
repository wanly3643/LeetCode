public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
    
        int count = 0;
        s = s.trim();

        for (int j = s.length() - 1; j >= 0; j --) {
            if (s.charAt(j) == ' ') {
                break;
            } else {
                count ++;
            }
        }

        return count;
    }
}