import java.util.HashMap;
import java.util.HashSet;

public class isValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> set_col = new HashSet<>();
        HashSet<Integer> set_row = new HashSet<>();
        for (int i = 0; i < 9; i += 1) {
            set_col.clear();
            set_row.clear();
            for (int k = 0; k < 9; k += 1) {
                int row = board[i][k] - '0';
                int col = board[k][i] - '0';
                if (set_row.contains(row)) {
                    return false;
                } else if (row != -2) {
                    set_row.add(board[i][k] - '0');
                }
                if (set_col.contains(col)) {
                    return false;
                } else if (col != -2) {
                    set_col.add(board[k][i] - '0');
                }
            }
        }

        HashSet<Integer> set_block = new HashSet<>();
        for (int i = 0; i < 9; i += 3) {
            for (int k = 0; k < 9; k += 3) {
                // 3x3 block
                set_block.clear();
                for (int r = i; r < i + 3; r += 1) {
                    for (int c = k; c < k + 3; c += 1){
                       int num = board[r][c] - '0';
                       if (set_block.contains(num)) {
                           return false;
                       } else if (num != -2) {
                           set_block.add(num);
                       }
                    }
                }
            }
        }
        return true;
    }
}
