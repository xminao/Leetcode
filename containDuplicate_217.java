import java.util.HashSet;

public class containDuplicate_217 {
    /**
     * 217. 存在重复元素
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3,1]
     * 输出：true
     * 示例 2：
     *
     * 输入：nums = [1,2,3,4]
     * 输出：false
     *
     * 解法：维护一个Set，判断Set和原数组长度是否一致，一致则没有重复的。
     */
    public boolean containDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return nums.length != set.size();
    }
}
