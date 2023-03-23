public class sortedSquared_977 {
    /**
     * 977. 有序数组的平方
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     * 解法： 双指针，原数组非递减，则平方后的最大值在两端出现，据此解题。
     */
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int lo = 0; // start point
        int hi = nums.length - 1; // end point
        int end = nums.length - 1; // result array point
        int[] result = new int[nums.length];
        while (lo <= hi) {
            if (lo == hi) {
                result[end] = nums[lo] * nums[lo];
                lo += 1;
            } else if (nums[lo] * nums[lo] < nums[hi] * nums[hi]) {
                result[end] = nums[hi] * nums[hi];
                end -= 1;
                hi -= 1;
            } else if (nums[lo] * nums[lo] >= nums[hi] * nums[hi]) {
                result[end] = nums[lo] * nums[lo];
                end -= 1;
                lo += 1;
            }
        }
        return result;
    }
}
