public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        int count = 0;
        ListNode cmp = head;
        while (cmp != null) {
            cmp = cmp.next;
            count ++;
        }

        int[] vals = new int[count];
        int idx = 0;
        cmp = head;
        while (cmp != null) {
            vals[idx ++] = cmp.val;
            cmp = cmp.next;
        }

        int i = 0;
        int j = vals.length - 1;
        while (i <= j) {
            if (vals[i ++] != vals[j --]) {
                return false;
            }
        }

        return true;
    }
}