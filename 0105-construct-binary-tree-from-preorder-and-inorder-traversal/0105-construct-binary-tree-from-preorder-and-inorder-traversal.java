// class Solution {

//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         return helper(preorder, 0, preorder.length - 1,  inorder, 0, inorder.length - 1);
//     }

//     public TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {

//         if (ps > pe || is > ie) {
//             return null;
//         }

//         // Preorder ka first element = root
//         int rootValue = preorder[ps];
//         TreeNode root = new TreeNode(rootValue);

//         // Inorder me root ka index
//         int index = is;

//         while (inorder[index] != rootValue) {
//             index++;
//         }

//         // Left subtree ke elements
//         int leftSize = index - is;

//         root.left = helper(
//             preorder,
//             ps + 1,
//             ps + leftSize,
//             inorder,
//             is,
//             index - 1
//         );

//         // Right subtree
//         root.right = helper(preorder,ps + leftSize + 1,pe,inorder,index + 1, ie);

//         return root;
//     }
// }
class Solution {
    public TreeNode helper(int[] preorder, int prelo, int prehi,
                           int[] inorder, int inlo, int inhi) {

        if (prelo > prehi) return null;

        TreeNode root = new TreeNode(preorder[prelo]);

        int i = inlo;
        while (inorder[i] != preorder[prelo]) i++;

        int leftsize = i - inlo;

        root.left = helper(preorder, prelo + 1, prelo + leftsize,
                           inorder, inlo, i - 1);

        root.right = helper(preorder, prelo + leftsize + 1, prehi,
                            inorder, i + 1, inhi);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder, 0, n - 1, inorder, 0, n - 1);
    }
}