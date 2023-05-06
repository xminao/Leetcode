public class MyLinkedList_707 {
    /**
     * 707. 设计链表
     * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
     *
     * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
     *
     * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
     *
     * 实现 MyLinkedList 类：
     *
     * MyLinkedList() 初始化 MyLinkedList 对象。
     * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
     * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
     * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
     * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
     * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
     *
     * debug之路：
     *      他妈的调用别的add size重复添加了 草
     */
    private class Node {
        Node prev;
        Node next;
        int val;
        public Node(int val) { this.val = val; }
        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private Node tail;
    private int size;

    public MyLinkedList_707() {
        this.sentinel = new Node(-1);
        this.tail = new Node(-1);
        sentinel.next = tail;
        tail.prev = sentinel;
        this.size = 0;
    }

    public int get(int index) {
        Node node = getNode(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val, sentinel, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
        this.size += 1;
    }

    public void addAtTail(int val) {
        Node node = new Node(val, tail.prev, tail);
        tail.prev.next = node;
        tail.prev = node;
        this.size += 1;
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node p = getNode(index);
            Node node = new Node(val, p.prev, p);
            p.prev.next = node;
            p.prev = node;
            this.size += 1;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;
        Node p = getNode(index);
        p.prev.next = p.next;
        p.next.prev = p.prev;
        this.size -= 1;
    }

    private Node getNode(int index) {
        Node node = null;
        if (index >= size) return node;
        boolean isLeft = index < (size / 2);
        if (isLeft) {
            Node p = sentinel;
            while (index >= 0) {
                p = p.next;
                index -= 1;
            }
            node = p;
        } else {
            Node p = tail;
            index = size - index;
            while (index > 0) {
                p = p.prev;
                index -= 1;
            }
            node = p;
        }
        return node;
    }
}
