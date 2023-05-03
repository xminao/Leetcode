import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findWords_212 {
    private int m;
    private int n;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        int[][] visited = new int[m][n];
        root = new TreeNode();
        for (String str : words) {
            addWord(str);
        }

        for (int i = 0; i < m; i += 1) {
            for (int k = 0; k < n; k += 1) {
                search(board, visited, 0, 0, result, root);
            }
        }
        return result;
    }

    private void search(char[][] board, int[][] visited, int row, int col, List<String> result, TreeNode node) {
        // 判断是否越界或者已经访问
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] == -1) {
            return;
        }
        int c = board[row][col] - 'a';
        node = node.children[c];
        if (node == null) return;

        visited[row][col] = -1;
        if (node.isWord) {
            result.add(node.val);
            node.isWord = false; // 防止重复
        }

        search(board, visited, row + 1, col, result, node); // 下
        search(board, visited, row - 1, col, result, node); // 上
        search(board, visited, row, col + 1, result, node); // 右
        search(board, visited, row, col - 1, result, node); // 左
        visited[row][col] = 0;
    }
    // 字典树
    private class TreeNode {
        String val;
        boolean isWord;
        TreeNode[] children;
        public TreeNode() {
            val = null;
            isWord = false;
            children = new TreeNode[26];
        }
    }

    private TreeNode root;

    private void addWord(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i += 1) {
            int c = word.charAt(i) - 'a';
            if (node.children[c] == null) {
                node.children[c] = new TreeNode();
            }
            node = node.children[c];
        }
        node.isWord = true;
        node.val = word;
    }

}
