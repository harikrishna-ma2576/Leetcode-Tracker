// Last updated: 08/10/2026, 09:22:30
1class Solution {
2    public int sumOfLeftLeaves(TreeNode root){
3        if(root==null)
4        return 0;
5        
6        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right)+helper(root);
7}
8  
9
10int helper(TreeNode root){
11    if(root==null){
12        return 0;
13        }
14    if(root.left!=null && root.left.left==null && root.left.right==null){
15        return root.left.val;
16    }
17    return 0;
18}
19}