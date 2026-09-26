class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p and q found in different subtrees
        if (left != null && right != null) {
            return root;
        }

        // Return whichever subtree contains p or q
        if (left != null) {
            return left;
        }

        return right;
    }
}