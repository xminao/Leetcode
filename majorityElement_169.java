public class majorityElement_169 {
    /**
     *169. 多数元素
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 解法：
     *      Boyer-Moore 投票算法
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = Integer.MAX_VALUE;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }
            count += (i == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
