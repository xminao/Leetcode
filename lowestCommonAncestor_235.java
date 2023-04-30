public class lowestCommonAncestor_235 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 235. 二叉搜索树的最近公共祖先
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 解法：
     *      如果两个结点在当前根节点两侧，则返回当前根节点，如果在一侧则递归该侧树，可以利用二叉搜索树的性质。
     */


    private TreeNode ancestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ancestor;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q) {
        // if ((root.val - p.val) * (root.val - q.val) <= 0) { // 如果两个结点在当前根节点两边
        if ((root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val)) {
            ancestor = root;
            return;
        } else if (root.val < p.val && root.val < q.val) { // 如果两个结点在当前根节点右边，则继续递归
            helper(root.right, p, q);
        } else {
            helper(root.left, p, q);
        }
    }
}
