public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode start = head;
        int count = 0;
        while (start != null && count < k) {
            start = start.next;
            count ++;
        }

        // If k is beyond the range, consider list as circle.
        if (start == null) {
            k = k % count;
            count = 0;
            start = head;
            while (count < k) {
                start = start.next;
                count ++;
            }
        }

        ListNode prev = head;
        while (start.next != null) {
            prev = prev.next;
            start = start.next;
        }

        start.next = head;
        head = prev.next;
        prev.next = null;

        return head;
    }
}