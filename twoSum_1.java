import java.util.HashMap;

public class twoSum_1 {
    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     *
     * 解法：
     *      维护一个Map（映射值到索引），遍历一遍数组，寻找target - 当前值，如果有则返回当前索引和Map中的索引作为结果，没有则继续遍历。
     *      这样边遍历数组边维护散列表只需要O(n)的时间即可找到结果。
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i += 1) {
           if (map.containsKey(target - nums[i])) {
               result[0] = map.get(target - nums[i]);
               result[1] = i;
               return result;
           } else {
               map.put(nums[i], i);
           }
        }
        return result;
    }
}
