public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Swap head and its next;
        ListNode newHead = head.next;
        head.next = newHead.next;
        newHead.next = head;

        ListNode pLeft = head;
        ListNode pRight = head;

        while (pRight.next != null && pRight.next.next != null) {
            pLeft = pRight.next;
            pRight.next = pLeft.next;
            pRight = pLeft;
            pLeft = pLeft.next;
            pRight.next = pLeft.next;
            pLeft.next = pRight;
        }

        return newHead;
    }
}