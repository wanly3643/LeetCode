public class Solution {
    private static final String[] preserved = new String[] {
        "1",
        "11",
        "21",
        "1211",
        "111221"
    };

    public String countAndSay(int n) {
        if (n < 6) {
            return preserved[n - 1];
        } else {
            String str = preserved[4];
            for (int i = 5; i < n; i ++) {
                str = countAndSayString(str);
            }
            return str;
        }
    }

    private String countAndSayString(String str) {
        char pre = str.charAt(0);
        int count = 1;

        char next = '1';
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i ++) {
            next = str.charAt(i);
            if (next == pre) {
                count ++;
            } else {
                sb.append(count);
                sb.append(pre);

                // reset
                pre = next;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(pre);

        return sb.toString();
    }
}