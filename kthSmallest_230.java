public class kthSmallest_230 {
    /**
     * 230. 二叉搜索树中第K小的元素
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     *
     * 解法：
     *      中序遍历，维护一个count找倒数第k个数字
     */
    private int count;
    private int result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        count -= 1;
        if (count == 0) result = root.val;
        inOrder(root.right);
    }
}
