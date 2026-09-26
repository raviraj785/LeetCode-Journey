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

    // Left to Right
    public void nthLevel(TreeNode root, int n, List<Integer> list) {

        if (root == null) return;

        if (n == 1) {
            list.add(root.val);
            return;
        }

        nthLevel(root.left, n - 1, list);
        nthLevel(root.right, n - 1, list);
    }

    // Right to Left
    public void nthLevel2(TreeNode root, int n, List<Integer> list) {

        if (root == null) return;

        if (n == 1) {
            list.add(root.val);
            return;
        }

        nthLevel2(root.right, n - 1, list);
        nthLevel2(root.left, n - 1, list);
    }

    // Height of tree
    public int height(TreeNode root) {

        if (root == null) return 0;

        return 1 + Math.max(
            height(root.left),
            height(root.right)
        );
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        int h = height(root);

        for (int level = 1; level <= h; level++) {

            List<Integer> list = new ArrayList<>();

            if (level % 2 == 1) {
                // Odd level -> Left to Right
                nthLevel(root, level, list);
            } 
            else {
                // Even level -> Right to Left
                nthLevel2(root, level, list);
            }

            ans.add(list);
        }

        return ans;
    }
}