import java.util.List;

public class reverseList_206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 206. 反转链表
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     * 解法：
     *      ① 迭代法：
     *              三个指针：当前节点、上一个节点、下一个节点
     *              保存当前节点的下一个节点，将当前指针指向上一个节点，上一个节点指向当前节点，当前节点指向下一个节点。
     *              当前节点为null时迭代完成，返回上一个节点即为新链表的头节点。
     *
     *      ② 遍历法：
     *              传如上的三个参数。
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode reverse(ListNode prev, ListNode curr, ListNode next) {
        if (curr == null) {
            return prev;
        }
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        return reverse(prev, curr, next);
    }
}
