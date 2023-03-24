import java.util.HashMap;
import java.util.HashSet;

public class lengthOfLongestSubstring_3 {
    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 解法：滑动窗口
     *      维护一个集合Set，判断窗口右指针要添加的字母是否在Set中，在则滑动左窗口（并删除左指针在Set中的字母），
     *      直至Set中没有要新添加的字母，添加新字母至窗口中，继续右滑动。
     *      维护一个Map的时间复杂度和空间复杂度太大。
     */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxL = 0;
        for (int right = 0; right < s.length(); right += 1) { // move the right pointer.
            char c = s.charAt(right);
            while (set.contains(c)) { // move the left pointer.
                set.remove(s.charAt(left));
                left += 1;
            }
            set.add(c);
            maxL = Math.max(maxL, right - left + 1);
        }

        return maxL;
    }
}
