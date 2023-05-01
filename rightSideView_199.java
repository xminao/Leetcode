import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class rightSideView_199 {
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

    /**
     * 199. 二叉树的右视图
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * 解法：
     *      层序遍历，取每层最后一个。
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (queue.size() != 0) {
            int len = queue.size();
            while (len > 0) {
                TreeNode tmp = queue.pollFirst();
                if (len == 1) {
                    result.add(tmp.val);
                }
                len -= 1;
                if (tmp.left != null) queue.offerLast(tmp.left);
                if (tmp.right != null) queue.offerLast(tmp.right);
            }
        }
        return result;
    }
}
