
class Solution {

    public void inorder(TreeNode root, List<Integer> arr) {
        if (root == null) return;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }

    public TreeNode buildBST(List<Integer> arr, int st, int end) {
        if (st > end) return null;

        int mid = st + (end - st) / 2;

        TreeNode root = new TreeNode(arr.get(mid));

        root.left = buildBST(arr, st, mid - 1);
        root.right = buildBST(arr, mid + 1, end);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();

        inorder(root, arr);

        return buildBST(arr, 0, arr.size() - 1);
    }
}
