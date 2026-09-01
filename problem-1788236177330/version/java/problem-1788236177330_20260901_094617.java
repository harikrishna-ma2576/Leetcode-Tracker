// Last updated: 01/09/2026, 09:46:17
1class Solution {
2    public boolean isBalanced(TreeNode root) {
3        int[] result = dfs(root);
4        return result[0] == 1;        
5    }
6
7    private int[] dfs(TreeNode node) {
8        if (node == null) return new int[]{1, 0}; // {isBalanced (1 for true, 0 for false), height}
9        
10        int[] left = dfs(node.left);
11        int[] right = dfs(node.right);
12        
13        boolean isBalanced = left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1;
14        
15        return new int[]{isBalanced ? 1 : 0, 1 + Math.max(left[1], right[1])};
16    }    
17}