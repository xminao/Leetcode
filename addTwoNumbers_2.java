public class addTwoNumbers_2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 2. 两数相加
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 解法：
     *      注意进位边界条件。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;

        // 进位
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val_1 = (l1 == null ? 0 : l1.val);
            int val_2 = (l2 == null ? 0 : l2.val);

            // new digit
            int val = val_1 + val_2 + carry;
            carry = val / 10;
            val = val % 10;
            p.next = new ListNode(val);

            // update ptrs
            p = p.next;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }

        return dummy.next;
    }
}