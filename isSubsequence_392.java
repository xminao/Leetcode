public class isSubsequence_392 {
    /**
     * 392. 判断子序列
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     *
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     *
     * 解法：
     *      双指针，一个指针指向t一个指向s，一直移动t指针，当s指针和t指针指向字符相同，则移动s指针。
     *      返回s指针值是否等于字符串s长度。
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int s_pointer = 0;
        int t_pointer = 0;

        while (t_pointer < t_arr.length) {
            if (s_pointer == s_arr.length) break;
            if (s_arr[s_pointer] == t_arr[t_pointer]) {
                s_pointer += 1;
            }
            t_pointer += 1;
        }

        return s_pointer == s_arr.length;
    }
}
