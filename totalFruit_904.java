import java.util.HashMap;

public class totalFruit_904 {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) return 0;
        HashMap<Integer, Integer> _mapping = new HashMap<>();
        int left = 0;
        int total = 0;
        int result = 0;
        for (int right = 0; right < fruits.length; right += 1) { // move the right slide pointer.
            int fruit_f = fruits[right];
            if (_mapping.containsKey(fruit_f)) {
                _mapping.put(fruit_f, _mapping.get(fruit_f) + 1);
            } else {
                _mapping.put(fruit_f, 1);
            }
            total += 1;

            while (_mapping.size() > 2) { // move the left slide pointer.
                int fruit_l = fruits[left];
                if (_mapping.get(fruit_l) == 1) {
                    _mapping.remove(fruit_l);
                } else {
                    _mapping.put(fruit_l, _mapping.get(fruit_l) - 1);
                }
                total -= 1;
                left += 1;
            }

            if (total > result) {
                result = total;
            }
        }
        return result;
    }
}
