import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class levelOrder_102 {
    /**
     * 102. 二叉树的层序遍历
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     *
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 结果列表
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;
        // 维护一个结点队列
        // 先root进队列，即第一层进队列，第一层全部进队列后开始出队列
        // 每个结点出队列之前将左右子树进队列，直到该层结点都出队列，此时下一层的结点都进入队列。
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();

            // queue is not empty
            while (len > 0) {
                TreeNode tmp = queue.poll();
                itemList.add(tmp.val);

                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
                len -= 1;
            }

            resList.add(itemList);
        }
        return resList;
    }
}
