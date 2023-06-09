public class reorderList_143 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        // split two part of linklist, using slow fast pointer.
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second part of linkedList.
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode next = null;
        while (second != null) {
            next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        // combine two linkedList.
        second = prev;
        ListNode first = head;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}
