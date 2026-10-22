
// class Solution {

//     // root se start hone wale paths
//     public int pathFrom(TreeNode root, long targetSum) {

//         if (root == null) {
//             return 0;
//         }

//         int count = 0;

//         // Current node ko path me include kiya
//         if (root.val == targetSum) {
//             count++;
//         }

//         // Left side
//         count += pathFrom(root.left, targetSum - root.val);

//         // Right side
//         count += pathFrom(root.right, targetSum - root.val);

//         return count;
//     }

//     public int pathSum(TreeNode root, int targetSum) {

//         if (root == null) {
//             return 0;
//         }

//         // Current node se path start
//         int count = pathFrom(root, targetSum);

//         // Left subtree se path start
//         count += pathSum(root.left, targetSum);

//         // Right subtree se path start
//         count += pathSum(root.right, targetSum);

//         return count;
//     }
// }
class Solution {

    public int noOfPaths(TreeNode root, long targetSum) {
        if (root == null) return 0;

        int count = 0;

        if ((long)(root.val) == targetSum) count++;

        return count
                + noOfPaths(root.left, targetSum - (long)(root.val))
                + noOfPaths(root.right, targetSum - (long)(root.val));
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int count = noOfPaths(root, (long)(targetSum));

        count += (pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum));

        return count;
    }
}