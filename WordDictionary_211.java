public class WordDictionary_211 {
    /**
     * 211. 添加与搜索单词 - 数据结构设计
     * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
     *
     * 实现词典类 WordDictionary ：
     *
     * WordDictionary() 初始化词典对象
     * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
     * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
     *
     * 解法：
     *      前缀树
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

    public WordDictionary_211() {
        root = new TreeNode();
    }

    public void addWord(String word) {
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
        return search(word, root, 0);
    }

    private boolean search(String word, TreeNode node, int sIndex) {
        int len = word.length();
        if (sIndex == len) return node.isWord;
        char c = word.charAt(sIndex);
        if (c == '.') {
            for (int i = 0; i < 26; i += 1) {
                if (node.children[i] != null && search(word, node.children[i], sIndex + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            int n = c - 'a';
            if (node.children[n] == null) {
                return false;
            }
            return search(word, node.children[n], sIndex + 1);
        }
    }
}
