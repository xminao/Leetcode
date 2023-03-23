public class minSubArrayLen_209 {
    /**
     * 209. 长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     * 解法：滑动窗口，如果窗口值大于target -> 移动窗口左指针；
     *              如果窗口值小于target -> 移动窗口右指针。
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int total = 0;
        int len = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right += 1) { // move the right pointer.
            total += nums[right];
            while (total >= target) { // move the left pointer.
                if (right - left + 1 < len) {
                    len = right - left + 1;
                }
                total -= nums[left];
                left += 1;
            }
        }

        if (len == Integer.MAX_VALUE) {
            len = 0;
        }

        return len;
    }
}
