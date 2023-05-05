import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class kClosest {
    public int[][] kClosest(int[][] points, int k) {
        /**
         * 973. 最接近原点的 K 个点
         * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
         *
         * 这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)2 + (y1 - y2)2 ）。
         *
         * 你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。
         *
         * 解法：
         *      大根堆，用int[]作泛型类型
         */
//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < points.length; i += 1) {
//            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
//            map.put(i, dist);
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            pq.offer(entry);
//        }
//        int[][] result = new int[k][2];
//        for (int i = 0; i < k; i += 1) {
//            int index = pq.poll().getKey();
//            result[i] = points[index];
//        }
//        return result;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int sum1 = o1[0]*o1[0] + o1[1]*o1[1];
                int sum2 = o2[0]*o2[0] + o2[1]*o2[1];
                return sum1 - sum2;
            }
        });
        for (int[] arr : points) {
            pq.offer(arr);
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i += 1) {
            result[i] = pq.poll();
        }
        return result;
    }
}
