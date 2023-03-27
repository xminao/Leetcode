import java.util.HashSet;
public class longestConsecutive_128 {
    /**
     * 128. 最长连续序列
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * 解法：
     *      维护一个Set，遍历nums，每当数字在Set中就遍历它的左侧连续数字和右侧连续数字是否在Set集合中，在就计数+1，并从Set中删除。
     *      为什么计数后要删除？因为如果不删除，当遍历到这数字后得到的结果重复。
     *
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int maxL = 0;
        for (int i : nums) {
            if (set.contains(i)) {
                int count = 1;
                set.remove(i);
                int left = i - 1;
                int right = i + 1;
                while (set.contains(left)) {
                    count += 1;
                    set.remove(left);
                    left -= 1;
                }
                while (set.contains(right)) {
                    count += 1;
                    set.remove(right);
                    right += 1;
                }

                maxL = Math.max(maxL, count);
            }
        }
        return maxL;
    }
}
