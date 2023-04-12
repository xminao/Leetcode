import java.util.HashMap;

public class offer_07 {

    /**
     * 剑指 Offer 07. 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     *
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * 解法：
     *      前序遍历的第一个结点一定是二叉树的根结点。
     *      根据根结点可以将中序遍历的分为 左子树 | 根结点 | 右子树
     *      对每一个子树进行递归重建。
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 记录结点在中序遍历中的索引位置, <val, index>
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i += 1) {
            map.put(inorder[i], i);
        }
        return helper(0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     *
     * @param preL 前序遍历左端点
     * @param preR 前序遍历右端点
     * @param inL 中序遍历左端点
     * @param inR 中序遍历右端点
     * @return
     */
    private TreeNode helper(int preL, int preR, int inL, int inR) {
        // is done.
        if (preL > preR || inL > inR) return null;
        // get root val.
        // the first element of preorder is root.
        int pivotVal = preorder[preL];
        // get root index in inorder.
        int pivotIndex = map.get(pivotVal);
        // build the Tree
        TreeNode node = new TreeNode(pivotVal);
        // recurse build
        node.left = helper(preL + 1, preL + (pivotIndex - inL), inL, pivotIndex - 1);
        node.right = helper(preL + (pivotIndex - inL) + 1, preR, pivotIndex + 1, inR);
        return node;
    }

}
