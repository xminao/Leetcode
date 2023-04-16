public class removeDuplicates_26 {
    public int removeDuplicates(int[] nums) {
        /**
         * 26. 删除有序数组中的重复项
         * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
         *
         * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
         *
         * 将最终结果插入 nums 的前 k 个位置后返回 k 。
         *
         * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
         *
         * 解法：
         *      双指针。一个构造数组，一个找不同的元素，找到不同的元素，左指针就移动并填充。
         */
        if (nums.length <= 1) return nums.length;
        int left = 0; // 构造数组
        int right = 1; // 寻找不同的元素
        while (right <= nums.length - 1) {
            if (nums[right] != nums[left]) {
                nums[left + 1] = nums[right];
                left += 1;
            }
            right += 1;
        }
        return left + 1;
    }
}
