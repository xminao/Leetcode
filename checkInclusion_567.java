public class checkInclusion_567 {
    /**
     * 567. 字符串的排列
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
     *
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     *
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     *
     * 解法： 固定滑动窗口，窗口长度和s1相同。
     *       维护两个26字母的数组（或者Map），如果两个数组中同一字母的数量相同则match（都为0也是match）。
     *       匹配数为26即找到了有效的窗口（窗口内的字符串是s1的一种排列）。
     *       以固定长度，每次一个字母滑动（右指针滑动一次，左指针也滑动一次，之后判断match是否为26）。时间复杂度为O(n)。
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] s1_arr = new int[26]; // s1 mapping char to count
        int[] s2_arr = new int[26]; // s2 mapping char to count (in slide windows).
        for (int i = 0; i < s1.length(); i += 1) {
            s1_arr[s1.charAt(i) - 'a'] += 1;
            s2_arr[s2.charAt(i) - 'a'] += 1;
        }

        int matches = 0;
        for (int i = 0; i < 26; i += 1) {
            if (s1_arr[i] == s2_arr[i]) {
                matches += 1;
            }
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right += 1) {
            if (matches == 26) return true;

            int index = s2.charAt(right) - 'a';
            s2_arr[index] += 1;
            if (s1_arr[index] == s2_arr[index]) {
                matches += 1;
            } else if (s1_arr[index] + 1 == s2_arr[index]) { // if original match, matches decrement.
                matches -= 1;
            }

            index = s2.charAt(left) - 'a';
            s2_arr[index] -= 1;
            if (s1_arr[index] == s2_arr[index]) {
                matches += 1;
            } else if (s1_arr[index] - 1 == s2_arr[index]) { // if original match, matches decrement.
                matches -= 1;
            }
            left += 1;
        }

        return matches == 26;
    }

}
