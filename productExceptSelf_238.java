public class productExceptSelf_238 {
    /**
     * 238. 除自身以外数组的乘积
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     *
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     *
     * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     *
     * 解法：
     *      维护一个前部分乘积数组prefix和后部分乘积数组suffix。
     *      第一遍从前向后遍历获得每个nums中整数的前部分乘积值数组prefix，
     *      第二遍从后向前遍历获得每个nums中整数的后部分乘积值数组suffix，
     *      两个数组同索引值相乘可得最终输出结果，
     *      如果维护一个当前索引值的前部分乘积变量pre，和当前索引值的后部分乘积变量suf，就可以直接在一个数组中操作。
     */
    public int[] productExceptSelf(int[] nums) {
        int pre = 1;
        int suf = 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i += 1) {
            result[i] = pre;
            pre = pre * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i -= 1) {
            result[i] = suf * result[i];
            suf =  suf * nums[i];
        }

        return result;
    }
}
