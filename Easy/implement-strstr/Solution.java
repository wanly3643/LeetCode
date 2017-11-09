class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() < 1) {
            return 0;
        }

        int j = 0;
        boolean found = true;
        for (int i = 0; i <= haystack.length() - needle.length(); i ++) {
            while (j < needle.length()) {
                if (needle.charAt(j ++) != haystack.charAt(i ++)) {
                    found = false;
                    break;
                }
            }

            // back to where it starts comparasion
            i -= j;

            // if all matched, return index
            if (found) {
                return i;
            }

            j = 0;
            found = true;
        }

        return -1;
    }
}