public class findDuplicate_287 {
    /**
     * 287. 寻找重复数
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
     *
     * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
     *
     * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
     *
     * 解法：
     *      数组可以看作一个环链表，找到slow pointer和fast pointer的环内相交点，用Floyd算法。
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        // find the meeting point of slow and fast pointer.
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        int ptr = 0;
        // find the cycle entrance.
        while (true) {
            if (nums[ptr] == nums[slow]) {
                return nums[ptr];
            }
            ptr = nums[ptr];
            slow = nums[slow];
        }
    }
}
