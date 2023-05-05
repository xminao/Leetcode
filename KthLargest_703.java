import java.util.PriorityQueue;

public class KthLargest_703 {
    /**
     * 703. 数据流中的第 K 大元素
     * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
     *
     * 请实现 KthLargest 类：
     *
     * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
     * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
     *
     * 解法：
     *      Keep track of the k biggest elements in the minimum priority queue q. q.peek() is the answer.
     */
    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargest_703(int k, int[] nums) {
        this.pq = new PriorityQueue<>(k);
        this.k = k;
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else if (pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
