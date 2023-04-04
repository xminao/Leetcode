public class removeNthFromEnd_19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 19. 删除链表的倒数第 N 个结点
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * 解法：
     *      使用两个指针，指针距离固定为n，当右指针为null，即到达尾部时，左指针.next即为要删除的节点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;
        while (n > 0 && right != null) {
            right = right.next;
            n -= 1;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // left is the node we need to remove.
        left.next = left.next.next;
        return dummy.next;
    }
}
