/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 解法：
 *      维护一个小于x的链表和一个大于等于x的链表，一次遍历最后合并。
 */
public class partition_86 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                p1.next = new ListNode(curr.val);
                p1 = p1.next;
            } else {
                p2.next = new ListNode(curr.val);
                p2 = p2.next;
            }
            curr = curr.next;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
