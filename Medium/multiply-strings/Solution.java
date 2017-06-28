public class Solution {
    public int toDigit(char c) {
        return (int)(c - '0');
    }
    public char toChar(int d) {
        return (char)('0' + d);
    }

    public void add(StringBuilder sb, int mul, int pos) {
        int d1 = mul % 10;
        int d2 = mul / 10;
        if (pos < sb.length()) {
            d1 += toDigit(sb.charAt(pos));
        } else {
            sb.append('0');
        }

        if (d1 >= 10) {
            d1 -= 10;
            d2 += 1;
        }

        sb.setCharAt(pos, toChar(d1));
        pos ++;
        while (pos < sb.length()) {
            d2 += toDigit(sb.charAt(pos));
            if (d2 >= 10) {
                d2 -= 10;
                sb.setCharAt(pos, toChar(d2));
                d2 = 1;
                pos ++;
            } else {
                break;
            }
        }

        if (d2 > 0) {
            if (pos < sb.length()) {
                sb.setCharAt(pos, toChar(d2));
            } else {
                sb.append(toChar(d2));
            }
        }

    }
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }

        if (num1.length() == 0 || num2.length() == 0) {
            return "";
        }

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        if ("1".equals(num1)) {
            return num2;
        }

        if ("1".equals(num2)) {
            return num1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i --) {
            for (int j = num2.length() - 1; j >= 0; j --) {
                add(sb, toDigit(num1.charAt(i)) * toDigit(num2.charAt(j)), num2.length() - 1 - j + (num1.length() - 1 - i));
            }
        }

        // Reverse to get the result
        char swap = 0;
        for (int j = 0; j < sb.length() / 2; j ++) {
            swap = sb.charAt(j);
            sb.setCharAt(j ,sb.charAt(sb.length() - 1 - j));
            sb.setCharAt(sb.length() - 1 - j, swap);
        }

        return sb.toString();
    }
}   