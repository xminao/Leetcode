import java.util.HashMap;

public class characterReplacement_424 {
    /**
     * 424. 替换后的最长重复字符
     * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
     *
     * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
     *
     * 解法： 滑动窗口
     *       有效窗口：窗口长度 - 窗口内最多的相同字母数 <= k
     *       如果窗口有效，继续右移，如果无效，移动左指针。
     *       不需要每次遍历HashMap获取最高频率的字母，只需要维护一个MaxF的最高频率对象。
     */
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxL = 0;
        int len = 0;
        int maxF = 0; // max frequently character
        for (int right = 0; right < s.length(); right += 1) {
            len = right - left + 1;
            char c_right = s.charAt(right);
            map.put(c_right, map.getOrDefault(c_right, 0) + 1);
            maxF = Math.max(maxF, map.get(c_right));

            while (len - maxF > k) { // invalid windows, move the left pointer.
                char c_left = s.charAt(left);
                map.put(c_left, map.get(c_left) - 1);
                left += 1;
                len = right - left + 1;
            }

            maxL = Math.max(maxL, len);
        }
        return maxL;
    }
}
