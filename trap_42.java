public class trap_42 {
    /**
     *  42. 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     *  解法：
     *      双指针，（两端点无法接到雨水，这很重要）。
     *      每个位置能接到的雨水数量和它的两侧最低的的那个高度有关（也即瓶颈）。
     *      如 1 0 2 ，中间的0由于两侧最低是1，能接到 1 - 0 = 1 格雨水。
     *      维护maxL和maxR变量，代表当前的左侧/右侧最高格，
     *      维护L和R两个指针变量，指向最左和最右，
     *      如果当前左侧最高格小于等于右侧最高格，就移动左指针算左侧的雨水，因为当前位置的雨水数量由两侧低的高度决定，也即左侧格。
     *      如果当前左侧最高格大于右侧最高格，就移动右指针算右侧的雨水，因为当前位置雨水数量由两侧中低的高度决定，也即右侧格子。
     *
     */
    public int trap(int[] height) {
        int maxL = height[0];
        int maxR = height[height.length - 1];
        int L = 0;
        int R = height.length - 1;
        int trapped = 0;
        while (L < R) {
            if (maxL <= maxR) {
                L += 1;
                if (maxL - height[L] > 0) {
                    trapped += maxL - height[L];
                }
                maxL = Math.max(maxL, height[L]);
            } else {
                R -= 1;
                if (maxR - height[R] > 0) {
                    trapped += maxR - height[R];
                }
                maxR = Math.max(maxR, height[R]);
            }
        }
        return trapped;
    }
}
