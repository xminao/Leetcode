import java.util.ArrayList;
import java.util.List;

public class MinStack_155 {
    /**
     * 155. 最小栈
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * 实现 MinStack 类:
     *
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。
     * int top() 获取堆栈顶部的元素。
     * int getMin() 获取堆栈中的最小元素。
     *
     * 解法：
     *      创建一个栈节点类，包括元素值和该元素之前的全栈全栈最小值。
     *      用list作顺序存储集合。
     */
    private class Node {
        private int val;
        private int minBefore;
        public Node(int val, int minBefore) {
            this.val = val;
            this.minBefore = minBefore;
        }

        public int getMinBefore() {
            return minBefore;
        }

        public int getVal() {
            return val;
        }
    }
    private List<Node> list;
    private int minVal;

    public MinStack_155() {
        list = new ArrayList<>();
        minVal = Integer.MAX_VALUE;
    }

    public void push(int val) {
        Node node = new Node(val, minVal);
        minVal = Math.min(minVal, val);
        list.add(node);
    }

    public void pop() {
        minVal = list.get(list.size() - 1).getMinBefore();
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1).getVal();
    }

    public int getMin() {
        return minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
