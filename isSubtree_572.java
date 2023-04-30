public class isSubtree_572 {

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

    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null) return true;
            if (root == null || subRoot == null) return false;
            return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean isSame(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            return p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
        }
    }
}
