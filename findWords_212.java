import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 212. 单词搜索 II
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 解法：
 *      构建字典树
 *      遍历数组
 */
public class findWords_212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i += 1) {
            for (int k = 0; k < board[0].length; k += 1) {
                dfs(board, i, k, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        // 如果访问过或者字典树中不存在
        if (c == '#' || node.next[c - 'a'] == null) return;
        node = node.next[c - 'a'];
        // 如果在字典树中是一个单词，添加到结果集
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // 防止重复
        }

        // 遍历四个方向
        board[i][j] = '#'; // 将当前节点设为访问过
        if (i > 0) dfs(board, i - 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);
        board[i][j] = c; // 复原以便下一次遍历
    }

    // 构建字典树
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (node.next[i] == null) {
                    node.next[i] = new TrieNode();
                }
                node = node.next[i];
            }
            node.word = w;
        }
        return root;
    }

    // 字典树节点
    private class TrieNode {
        String word;
        TrieNode[] next;
        public TrieNode() {
            word = null;
            next = new TrieNode[26];
        }
    }

}
