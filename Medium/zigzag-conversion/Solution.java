public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || "".equals(s) || numRows <= 1) {
            return s;
        }
        int lines = s.length() * (numRows - 1) / (numRows + numRows - 2) + 1;
        char[][] chars = new char[lines][numRows];
        int idx = 0;
        int charIdx = 0;

        char[] col = null;
        boolean end = false;
        while (idx < lines && !end) {
            // First column
            chars[idx ++] = col = new char[numRows];
            for (int i = 0; i < numRows; i ++) {
                col[i] = s.charAt(charIdx ++);
                if (charIdx >= s.length()) {
                    end = true;
                    break;
                }
            }

            if (end) {
                break;
            }

            for (int j = 0; j < numRows - 2 && idx < lines; j ++) {
                chars[idx ++] = col = new char[numRows];
                for (int i = 0; i < numRows; i ++) {
                    col[i] = 0;
                }

                col[numRows - j - 2] = s.charAt(charIdx ++);
                if (charIdx >= s.length()) {
                    end = true;
                    break;
                }
            }
        }

        // Rebuild the string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i ++) {
            for (int j = 0; j < lines; j ++) {
                if (chars[j][i] != 0) {
                    sb.append(chars[j][i]);
                }
            }
        }

        return sb.toString();
    }
}