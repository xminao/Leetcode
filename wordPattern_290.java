import java.util.HashMap;

public class wordPattern_290 {
    public boolean wordPattern(String pattern, String s) {
        String[] sList = s.split(" ");
        char[] pat = pattern.toCharArray();
        if (sList.length != pat.length) return false;
        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < pat.length; i += 1) {
            if (map.containsKey(pat[i]) && !map.get(pat[i]).equals(sList[i])) {
                return false;
            }
            if (!map.containsKey(pat[i]) && map.containsValue(sList[i])) {
                return false;
            }
            map.put(pat[i], sList[i]);
        }
        return true;
    }
}
