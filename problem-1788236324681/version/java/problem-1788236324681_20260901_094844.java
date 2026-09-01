// Last updated: 01/09/2026, 09:48:44
1class Solution {
2    public boolean hasPathSum(TreeNode root, int targetSum) {
3        if (root == null) return false;
4
5        if (root.left == null && root.right == null) {
6            return targetSum - root.val == 0;
7        }
8
9        targetSum -= root.val;
10
11        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);        
12    }
13}