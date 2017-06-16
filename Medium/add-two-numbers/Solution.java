
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode nl1 = l1;
        ListNode nl2 = l2;
        ListNode rl, rl2 = null;
        rl = rl2 = new ListNode(0);
        boolean more = false;
        int sum = 0;
        while (nl1 != null && nl2 != null) {
            sum = nl1.val + nl2.val;
            if (more) {
                sum += 1;
                more = false;
            }

            if (sum > 9) {
                sum -= 10;
                more = true;
            }
            rl2.next = new ListNode(sum);
            rl2 = rl2.next;
            nl1 = nl1.next;
            nl2 = nl2.next;
        }

        if (nl1 != null) {
            while (nl1 != null) {
                sum = nl1.val;
                if (more) {
                    sum += 1;
                    more = false;
                }

                if (sum > 9) {
                    sum -= 10;
                    more = true;
                }
                rl2.next = new ListNode(sum);
                rl2 = rl2.next;
                nl1 = nl1.next;
            }
        } else if (nl2 != null) {
            while (nl2 != null) {
                sum = nl2.val;
                if (more) {
                    sum += 1;
                    more = false;
                }

                if (sum > 9) {
                    sum -= 10;
                    more = true;
                }
                rl2.next = new ListNode(sum);
                rl2 = rl2.next;
                nl2 = nl2.next;
            }
        } else {
        }

        if (more) {
            rl2.next = new ListNode(1);
            rl2 = rl2.next;
        }

        return rl.next;
    }

    public static void main(String[] args) {
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(9);
        r2.next = new ListNode(9);

        Solution s = new Solution();
        ListNode r = s.addTwoNumbers(r1, r2);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}