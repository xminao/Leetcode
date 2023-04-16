public class removeDuplicates_80 {
    /**
     * 80. 删除有序数组中的重复项 II
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 解法：
     *      保留前两位；
     *      后面每一位和前第k个元素比较，如果不同则保留，如果不同则跳过再追加。
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int left = 0;
        for (int i : nums) {
            if (left < 2 || nums[left - 2] != i) {
                nums[left++] = i;
            }
        }
        return left;
    }
}
