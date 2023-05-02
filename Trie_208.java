public class Trie_208 {
    /**
     * 208. 实现 Trie (前缀树)
     * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
     *
     * 请你实现 Trie 类：
     *
     * Trie() 初始化前缀树对象。
     * void insert(String word) 向前缀树中插入字符串 word 。
     * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
     * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
     *
     *
     */
    private class TreeNode {
        public boolean isWord;
        public TreeNode[] children;
        public TreeNode() {
            isWord = false;
            children = new TreeNode[26];
        }
    }

    private TreeNode root;
    public Trie_208() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr = root;
        for (int i = 0; i < word.length(); i += 1) {
            int c = word.charAt(i) - 'a';
            if (curr.children[c] == null) {
                curr.children[c] = new TreeNode();
            }
            curr = curr.children[c];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TreeNode curr = root;
        for (int i = 0; i < word.length(); i += 1) {
            int c = word.charAt(i) - 'a';
            if (curr.children[c] == null) {
                return false;
            }
            curr = curr.children[c];
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = root;
        for (int i = 0; i < prefix.length(); i += 1) {
            int c = prefix.charAt(i) - 'a';
            if (curr.children[c] == null) {
                return false;
            }
            curr = curr.children[c];
        }
        return true;
    }
}