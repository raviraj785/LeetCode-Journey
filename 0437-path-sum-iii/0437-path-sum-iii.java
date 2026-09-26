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

    // root se start hone wale paths
    public int pathFrom(TreeNode root, long targetSum) {

        if (root == null) {
            return 0;
        }

        int count = 0;

        // Current node ko path me include karo
        if (root.val == targetSum) {
            count++;
        }

        // Left side
        count += pathFrom(root.left, targetSum - root.val);

        // Right side
        count += pathFrom(root.right, targetSum - root.val);

        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }

        // Current node se path start
        int count = pathFrom(root, targetSum);

        // Left subtree se path start
        count += pathSum(root.left, targetSum);

        // Right subtree se path start
        count += pathSum(root.right, targetSum);

        return count;
    }
}