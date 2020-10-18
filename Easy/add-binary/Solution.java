class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        boolean plus = false;
        char c1 = ' ';
        char c2 = ' ';
        while (i >= 0 && j >= 0) {
            c1 = a.charAt(i);
            c2 = b.charAt(j);

            if (c1 == '1' && c2 == '1') {
                if (plus) {
                    sb.insert(0, '1');
                } else {
                    sb.insert(0, '0');
                }
                plus = true;
            } else if (c1 == '0' && c2 == '0') {
                if (plus) {
                    sb.insert(0, '1');
                } else {
                    sb.insert(0, '0');
                }
                plus = false;
            } else {
                if (plus) {
                    sb.insert(0, '0');
                } else {
                    sb.insert(0, '1');
                    plus = false;
                }
            }

            i --;
            j --;
        }

        if (plus) {
            if (i >= 0) {
                while (i >= 0) {
                    c1 = a.charAt(i);
                    if (plus) {
                        if (c1 == '1') {
                            sb.insert(0, '0');
                        } else {
                            sb.insert(0, '1');
                            plus = false;
                        }
                    } else {
                        sb.insert(0, c1);
                    }

                    i --;
                }
            } else if (j >= 0) {
                while (j >= 0) {
                    c2 = b.charAt(j);
                    if (plus) {
                        if (c2 == '1') {
                            sb.insert(0, '0');
                        } else {
                            sb.insert(0, '1');
                            plus = false;
                        }
                    } else {
                        sb.insert(0, c2);
                    }
                    
                    j --;
                }
            }
        } else {
            if (i >= 0) {
                sb.insert(0, a.substring(0, i + 1));
            } else if (j >= 0) {
                sb.insert(0, b.substring(0, j + 1));
            }
        }

        //
        if (plus) {
            sb.insert(0, '1');
        }


        return sb.toString();
    }
}