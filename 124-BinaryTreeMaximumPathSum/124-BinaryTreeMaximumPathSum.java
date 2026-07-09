// Last updated: 09/07/2026, 15:14:36
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // ignore negative paths
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // path passing through current node
        int currentPath = node.val + left + right;

        // update global maximum
        maxSum = Math.max(maxSum, currentPath);

        // return one side to parent
        return node.val + Math.max(left, right);
    }
}