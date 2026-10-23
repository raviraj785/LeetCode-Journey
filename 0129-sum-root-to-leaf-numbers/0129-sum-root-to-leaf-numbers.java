
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int current) {
        if (root == null) {
            return 0;
        }

        current = current * 10 + root.val;

        // Leaf node
        if (root.left == null && root.right == null) {
            return current;
        }

        int left = dfs(root.left, current);
        int right = dfs(root.right, current);

        return left + right;
    }
}
