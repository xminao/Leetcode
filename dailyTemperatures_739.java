import java.util.LinkedList;

public class dailyTemperatures_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i += 1) {
            while (list.size() != 0 && temperatures[i] > temperatures[list.getLast()]) {
                int index = list.pollLast();
                result[index] = i - index;
            }
            list.offerLast(i);
        }
        return result;
    }
}
