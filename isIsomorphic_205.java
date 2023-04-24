import java.util.Arrays;
import java.util.HashMap;

public class isIsomorphic_205 {
    /**
     * 205. 同构字符串
     * 给定两个字符串 s 和 t ，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     *
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     *
     * 解法：
     *      ASCII字符范围 0-127，构建两个长度128的数组作为哈希表，一个哈希表表示s中字符映射对象，一个哈希表表示t中字符被谁映射。
     *      遍历判断 映射对象 和 被映射对象 是否都满足。
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] mapping = new int[128];
        int[] mapped = new int[128];
        Arrays.fill(mapping, -1);
        Arrays.fill(mapped, -1);
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        for (int i = 0; i < s_arr.length; i += 1) {
            if (mapping[s_arr[i]] != -1 && mapping[s_arr[i]] != t_arr[i]) {
                return false;
            }
            if (mapping[s_arr[i]] == -1 && mapped[t_arr[i]] != -1) {
                return false;
            }
            mapping[s_arr[i]] = t_arr[i];
            mapped[t_arr[i]] = s_arr[i];
        }
        return true;
    }
}
