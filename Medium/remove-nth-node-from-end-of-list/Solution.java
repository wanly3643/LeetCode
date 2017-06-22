public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0 || head == null) {
            return head;
        }

        ListNode pre = null;
        ListNode toRemove = head;

        ListNode headOrig = head;
        while (head != null && n > 0) {
            head = head.next;
            n --;
        }

        while (head != null) {
            pre = toRemove;
            toRemove  = toRemove.next;
            head = head.next;
        }

        if (pre == null) {
            return toRemove.next;
        } else {
            pre.next = toRemove.next;
            return headOrig;
        }
    }
}