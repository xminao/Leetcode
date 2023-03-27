
public class twoSum {
    /**
     * 167. 两数之和 II - 输入有序数组
     * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
     *
     * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
     *
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     *
     * 你所设计的解决方案必须只使用常量级的额外空间。
     *
     *
     * 示例 1：
     *
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
     *
     * 解法：
     *      双指针，两指针之和 == target：找到结果
     *            两指针之和 > target，向左移动右指针
     *            两指针之和 < target，向右移动左指针。
     */
    public static int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;
        int[] result = new int[2];
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum == target) {
                result[0] = lo + 1;
                result[1] = hi + 1;
                return result;
            } else if (sum > target) {
                hi -= 1;
            } else {
                lo += 1;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] n = {2, 7, 11, 15};
        int[] res = twoSum(n, 9);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
