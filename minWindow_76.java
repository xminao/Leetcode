import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class minWindow_76 {
    /**
     * 76. 最小覆盖子串
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     *
     *
     * 注意：
     *
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *
     *
     * 示例 1：
     *
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
     * 示例 2：
     *
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 解释：整个字符串 s 是最小覆盖子串。
     * 示例 3:
     *
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     *
     * 解法： 滑动窗口，维护两个Map。
     *       窗口无效（指窗口内字母和t中字母不都相符） ：移动右指针
     *       窗口有效（窗口内字母和t中字母都相符）：移动左指针
     *
     * 这里有一个Map.get的比较问题，如果调用一个Map<Object, Integer>的get方法，返回的是Integer，
     * 也就是返回了一个对象，Integer对象会缓存频繁使用的值，范围在-128 - 127之间，超过这个值就会new一个新对象，
     * 这样就会导致 == 比较失败，解决办法：使用get(i).intValue()方法，intValue()方法返回转换为int的Integer对象表示的值，
     * 或者使用equals比较。
     */
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        // map of string t, invariant
        HashMap<Character, Integer> map_t = new HashMap<>();
        // map of slide window
        HashMap<Character, Integer> map_w = new HashMap<>();

        // initialize the map of string t.
        for (int i = 0; i < t.length(); i += 1) {
            char c = t.charAt(i);
            map_t.put(c, map_t.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = map_t.size();
        int left = 0;
        int[] result = new int[]{-1, -1};
        int result_len = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right += 1) {
            // move the right pointer if window invalid
            char c = s.charAt(right);
            map_w.put(c, map_w.getOrDefault(c, 0) + 1);
            // use equals solve the Integer Compare.
            if (map_t.containsKey(c) && Objects.equals(map_t.get(c), map_w.get(c))) {
                have += 1;
            }

            // move the left pointer if window valid
            while (have == need) {
                // update the result
                if (right - left + 1 < result_len) {
                    result[0] = left;
                    result[1] = right;
                    result_len = right - left + 1;
                }

                // pop the left item from window.
                char c_left = s.charAt(left);
                map_w.put(c_left, map_w.get(c_left) - 1);
                if (map_t.containsKey(c_left) && map_w.get(c_left) < map_t.get(c_left)) {
                    have -= 1;
                }
                left += 1;
            }
        }

        if (result_len != Integer.MAX_VALUE) {
            return s.substring(result[0], result[1] + 1);
        }
        return "";
    }

}
