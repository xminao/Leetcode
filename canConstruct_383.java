import java.util.HashMap;

public class canConstruct_383 {
    /**
     * 383. 赎金信
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     *
     * 如果可以，返回 true ；否则返回 false 。
     *
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     *
     * 解法：
     *      哈希，一共就26个字母，用长度26的数组就可以。
     */
    public boolean canConstruct(String ransomNote, String magazine) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (char c : magazine.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//
//        for (char c : ransomNote.toCharArray()) {
//            if (!map.containsKey(c) || map.get(c) == 0) {
//                return false;
//            }
//            map.put(c, map.get(c) - 1);
//        }
//        return true;
        int[] arr = new int[26];
        for (char c : magazine.toCharArray()) {
            arr[c - 'a'] += 1;
        }

        for (char c : ransomNote.toCharArray()) {
            if (arr[c - 'a'] == 0) {
                return false;
            }
            arr[c - 'a'] -= 1;
        }

        return true;
    }
}
