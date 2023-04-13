import java.util.HashMap;

public class climbStairs_70 {
    /**
     *70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     *  解法：
     *      递归，第1阶有一种走法，第2阶有两种走法（base case）
     *      第n个台阶只能从 n-1 或者 n-2 台阶走上来，也就是 到n-1的走法 + 到n-2的走法
     */
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return helper(map, n);
    }

    private int helper(HashMap<Integer, Integer> map, int n) {
        if (n == 0) return 1;
        if (n == 1 || n == 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        // 第n个台阶只能从 n-1 或者 n-2 上来。
        // 到n-1的走法 + 到n-2的走法 = 到n的走法
        int result = helper(map, n - 1) + helper(map, n - 2);
        map.put(n, result);
        return result;
    }
}
