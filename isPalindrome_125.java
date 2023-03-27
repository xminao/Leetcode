public class isPalindrome_125 {
    /**
     * 125. 验证回文串
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     *
     * 字母和数字都属于字母数字字符。
     *
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     * 输入: s = "A man, a plan, a canal: Panama"
     * 输出：true
     * 解释："amanaplanacanalpanama" 是回文串。
     *
     * 解法：
     *      双指针。先将字符串转换为小写字符数组。
     *      左右指针推进，左指针index >= 右指针index则遍历完成。
     *      遇到非字母数字字符则继续移动指针，每次移动都要判断是否遍历完成，否则会溢出。
     */
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return false;
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toLowerCase().toCharArray();
        while (left < right) {
            char c_l = arr[left];
            char c_r = arr[right];
            while (!((c_l >= 'a' && c_l <= 'z') || (c_l >= '0' && c_l <= '9'))) {
                left += 1;
                if (left == right) {
                    return true;
                }
                c_l = arr[left];
            }
            while (!((c_r >= 'a' && c_r <= 'z') || (c_r >= '0' && c_r <= '9'))) {
                right -= 1;
                if (left == right) {
                    return true;
                }
                c_r = arr[right];
            }

            if (c_l != c_r) {
                return false;
            } else {
                left += 1;
                right -= 1;
            }
        }
        return true;
    }
}
