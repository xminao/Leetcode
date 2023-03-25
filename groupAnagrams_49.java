import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams_49 {
    /**
     * 49. 字母异位词分组
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     *
     *
     *
     * 示例 1:
     *
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 示例 2:
     *
     * 输入: strs = [""]
     * 输出: [[""]]
     *
     * 解法：散列表。
     *      统计字符串的每个字符数量作为哈希键，这里选择用另一个散列表做Key。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for (String s : strs) {
            HashMap<Character, Integer> _mapping = new HashMap<>();
            for (char c : s.toCharArray()) {
                _mapping.put(c, _mapping.getOrDefault(c, 0) + 1);
            }
            List<String> list = map.getOrDefault(_mapping, new ArrayList<>());
            list.add(s);
            map.put(_mapping, list);
        }

        for(List<String> l : map.values()) {
            result.add(l);
        }
        return result;
    }
}
