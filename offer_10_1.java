import java.util.HashMap;

public class offer_10_1 {

    /**
     * 剑指 Offer 10- I. 斐波那契数列
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 解法：
     *      递归，不过每次都用Map记录n的值，避免重复计算导致超时
     */

    public int fib(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return helper(map, n);
    }

    private int helper(HashMap<Integer, Integer> map, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = helper(map, n - 1) + helper(map, n - 2);
        result %= 1000000007;
        map.put(n, result );
        return result;
    }
}
