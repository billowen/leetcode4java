package addtwonumbers;

public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        int add = 0;
        ListNode l = null;
        ListNode start = null;
        do {
            int add1 = l1 == null ? 0 : l1.val;
            int add2 = l2 == null ? 0 : l2.val;
            int val = add1 + add2 + add;
            add = val / 10;
            val = val % 10;
            ListNode cur = new ListNode(val);
            if (l != null) {
                l.next = cur;
            } else {
                start = cur;
            }
            l = cur;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        } while (l1 != null || l2 != null);

        if (add != 0) {
            l.next = new ListNode(1);;
        }

        return start;
    }
}
