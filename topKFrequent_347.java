import java.util.*;

public class topKFrequent_347 {
    /**
     * 347. 前 K 个高频元素
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     *
     * 解法：
     *      1. 创建一个映射整数值到计数的散列表，使用优先队列返回前k个值即可。（Java实现）
     *      2. 维护一个nums同长数组，索引值为计数，数组内容为整数值数组。(维护一个bucket，Python思路，Java实现复杂)
     */
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        pq.addAll(map.entrySet());
        int[] result = new int[k];
        for (int i = 0; i < k; i += 1) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }

    public static void main(String args[]) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        topKFrequent(nums, 2);
    }
}
