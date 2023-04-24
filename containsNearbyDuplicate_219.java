import java.util.HashMap;

public class containsNearbyDuplicate_219 {
    /**
     *219. 存在重复元素 II
     * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3,1], k = 3
     * 输出：true
     * 示例 2：
     *
     * 输入：nums = [1,0,1,1], k = 1
     * 输出：true
     *
     * 解法：
     *    维护一个散列表，映射元素和其索引的关系
     *    遍历数组，如果散列表中有该元素并且当前元素的索引和散列表中元素的索引差值<=k则返回true
     *    无论散列表中是否有该元素都更新索引。（*）
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2 || k == 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>(); // mapping element to index.
        for (int i = 0; i < nums.length; i += 1) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
