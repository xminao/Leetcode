public class isHappy_202 {
    /**
     * 202. 快乐数
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」 定义为：
     *
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     *
     * 解法：
     *      快慢指针解决。如果是快乐数最后快慢指针都会变成1循环，如果不是快乐数也会因为循环变相同，但不是1.
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = squareSum(n);
        fast = squareSum(fast);
        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        }
        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int squareSum(int n) {
        int sum = 0;
        int last;
        while (n != 0) {
            last = n % 10;
            n = n / 10;
            sum += last * last;
        }
        return sum;
    }
}
