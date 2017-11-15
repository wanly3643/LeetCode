public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = null;
        newHead = l1;
        ListNode otherHead = l2;
        if (l1.val > l2.val) {
            newHead = l2;
            otherHead = l1;
        }

        ListNode tmp = newHead;
        ListNode tmpNew = newHead.next;
        ListNode tmpOther = otherHead;
        while (tmpNew != null && tmpOther != null) {
            if (tmpNew.val < tmpOther.val) {
                tmp.next = tmpNew;
                tmpNew = tmpNew.next;
            } else {
                tmp.next = tmpOther;
                tmpOther = tmpOther.next;
            }
            tmp = tmp.next;
        }
        
        if (tmpNew != null) {
            tmp.next = tmpNew;
        } else {
            tmp.next = tmpOther;
        }
        
        return newHead;
    }
}