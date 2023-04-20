import java.util.ArrayList;
import java.util.List;

public class spiralOrder_54 {
    /**
     * 54. 螺旋矩阵
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * 解法：
     *      设置四个方向，{x, y}，行为x，列为y；维护一个已走过的flags数组。判断各种边界条件然后改变方向（遇到墙壁，遇到已经走过的元素）
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int length = m * n;
        int[][] flags = new int[m][n]; // all zero
        int[][] direct = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}}; // up down left right
        int curr_direct = 3;
        int curr_length = 0;
        int x = 0;
        int y = 0;
        while (curr_length < length) {
            result.add(matrix[x][y]);
            flags[x][y] = 1;
            if (curr_direct == 3 && (y + 1 == n || flags[x][y + 1] == 1)) { // right to down
                curr_direct = 1;
            } else if (curr_direct == 1 && (x + 1 == m || flags[x + 1][y] == 1)) { // down to left
                curr_direct = 2;
            } else if (curr_direct == 2 && (y - 1 == -1 || flags[x][y - 1] == 1)) {
                curr_direct = 0;
            } else if (curr_direct == 3 && (x - 1 == -1 || flags[x - 1][y] == 1)) {
                curr_direct = 3;
            }
            x += direct[curr_direct][0];
            y += direct[curr_direct][1];
            curr_length += 1;
        }

        return result;
    }
}
