import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 解法：
 *      回溯，不用判断右下角和左下角，因为下面还没填充
 */
public class solveNQueens_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i += 1) {
            Arrays.fill(board[i], '.');
        }
        dfs(board, result, 0);
        return result;
    }

    private void dfs(char[][] board, List<List<String>> result, int row) {
        if (row == board.length) {
            List<String> item = new ArrayList<>();
            for (int i = 0; i < board.length; i += 1) {
                item.add(new String(board[i]));
            }
            result.add(item);
        }

        for (int i = 0; i < board.length; i += 1) {
            if (!isValid(board, row, i)) continue;
            board[row][i] = 'Q';
            dfs(board, result, row + 1);
            board[row][i] = '.';
        }
    }

    // 判断同一列，右上，左上就可以
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 判断同一列
        for (int i = 0; i < row; i += 1) {
            if (board[i][col] == 'Q') return false;
        }
        // 判断左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i -= 1, j -= 1) {
            if (board[i][j] == 'Q') return false;
        }
        // 判断右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i -= 1, j += 1) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
