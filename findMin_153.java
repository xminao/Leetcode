public class findMin_153 {
    /**
     *
     * 153. 寻找旋转排序数组中的最小值
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
     * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     *
     * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     *
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     *
     * 解法：
     *      时间复杂度O(log n)，考虑二分查找
     *      一个未旋转的数组直接返回最左的元素。
     *      一个旋转的数组有两部分，左边的部分是大的，右边的部分是小的，因为旋转将右边的元素转移到左边，
     *      执行二分查找，如果 [L] < [R] 代表已排序，取min([L], min)
     *      如果 [mid] >= [L] ，则 [mid] 在左部分，L + 1 向右查找，
     *      如果 [mid] < [L] ，则 [mid] 在右部分，更新min值，查找更小的值 R - 1。
     */
    public int findMin(int[] nums) {
        int min = nums[0];
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            if (nums[L] < nums[R]) {
                min = Math.min(min, nums[L]);
                break;
            }
            int mid = (L + R) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] >= nums[L]) { // search right area
                L = mid + 1;
            } else { //search left area
                R = mid - 1;
            }
        }
        return min;
    }
}
