import java.util.PriorityQueue;

public class findKthLargest_215 {
    /**
     * 215. 数组中的第K个最大元素
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     *
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     * 解法：
     *      优先队列
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            if (pq.size() < k) {
                pq.offer(i);
            } else {
                if (pq.peek() < i) {
                    pq.poll();
                    pq.offer(i);
                }
            }
        }
        return pq.peek();
    }
}
