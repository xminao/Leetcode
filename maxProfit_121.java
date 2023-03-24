public class maxProfit_121 {
    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     * 解法：滑动窗口，利益差大于0 -> 继续滑动右窗口
     *              利益查小于0 -> 滑动左窗口到当前右窗口位置（因为这意味着更低的买入价格出现）.
     */
    public int maxProfit(int[] prices) {
        int left = 0;
        int maxP = 0;
        for (int right = 1; right < prices.length; right += 1) {
            if (prices[right] > prices[left]) { // positive profit
                if (prices[right] - prices[left] > maxP) {
                    maxP = prices[right] - prices[left];
                }
            } else { // negative profit
                left = right;
            }
        }
        return maxP;
    }
}
