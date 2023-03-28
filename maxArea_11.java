public class maxArea_11 {
    /**
     * 11. 盛最多水的容器
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 解法：
     *      双指针，左指针高度 < 右指针高度，移动左指针
     *             左指针高度 >= 右指针高度，移动右指针。
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
           int area = (right - left) * Math.min(height[left], height[right]);
           max = Math.max(max, area);
           if (height[left] < height[right]) {
               left += 1;
           } else {
               right -= 1;
           }
        }
        return max;
    }
}
