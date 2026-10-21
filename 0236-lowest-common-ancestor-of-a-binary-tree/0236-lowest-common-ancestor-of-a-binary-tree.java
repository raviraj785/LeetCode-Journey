/*class Solution {

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
}*/
class Solution {

    public boolean contains(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;

        return contains(root.left, node)
            || contains(root.right, node);
    }

    public TreeNode lowestCommonAncestor(
        TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;
        if (p == root || q == root) return root;
        if (p == q) return p;

        boolean leftp = contains(root.left, p);
        boolean leftq = contains(root.left, q);

        if (leftp && leftq)
            return lowestCommonAncestor(root.left, p, q);

        if (!leftp && !leftq)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}