import java.util.HashMap;
import java.util.HashSet;

public class isAnagram_242 {
    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * 解法：
     *      根据题目，两个字符串应当同长度。字符串仅包含小写字母，即在a-z的26字母范围内，
     *      使用长度为26的数组遍历字符串s计数，接着遍历字符串t，在数组中存在则自减，不存在则并非字母异位词，
     *      最后不需要再次遍历数组确保都归零，因为两个字符串长度相同，只有都匹配才能通过第二个遍历。
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] s_count = new int[26];

        for (char c : s.toCharArray()) {
            s_count[c - 'a'] += 1;
        }

        for (char c : t.toCharArray()) {
            if (s_count[c - 'a'] > 0) {
                s_count[c - 'a'] -= 1;
            } else {
                return false;
            }
        }

        return true;
    }
}
