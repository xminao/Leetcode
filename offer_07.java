import java.util.HashMap;

public class offer_07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i += 1) {
            map.put(inorder[i], i);
        }
        return helper(preorder, map, 0, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, HashMap<Integer, Integer> map, int root, int left, int right) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        int i = map.get(preorder[root]);
        node.left = helper(preorder, map, root + 1, left, i - 1);
        node.right = helper(preorder, map, root + i - left + 1, i + 1, right);
        return node;
    }
}
