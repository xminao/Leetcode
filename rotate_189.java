public class rotate_189 {
    /**
     * 189. 轮转数组
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     * 解法：
     *      做三次旋转，第一次整个数组旋转，第二次旋转前k个元素，第三次旋转后面的元素，即可达到要求。
     *      k需要取模。
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k - 1, nums.length - 1);
    }

    // reverse the array, index start at left end at right
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left += 1;
            right -= 1;
        }
    }
}
