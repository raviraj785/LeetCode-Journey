/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1,
                      inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int ps, int pe,
                           int[] inorder, int is, int ie) {

        if (ps > pe || is > ie) {
            return null;
        }

        // Preorder ka first element = root
        int rootValue = preorder[ps];
        TreeNode root = new TreeNode(rootValue);

        // Inorder me root ka index
        int index = is;

        while (inorder[index] != rootValue) {
            index++;
        }

        // Left subtree ke elements
        int leftSize = index - is;

        root.left = helper(
            preorder,
            ps + 1,
            ps + leftSize,
            inorder,
            is,
            index - 1
        );

        // Right subtree
        root.right = helper(
            preorder,
            ps + leftSize + 1,
            pe,
            inorder,
            index + 1,
            ie
        );

        return root;
    }
}