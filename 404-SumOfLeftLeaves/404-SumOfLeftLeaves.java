// Last updated: 09/07/2026, 15:13:27
class Solution {
    public int sumOfLeftLeaves(TreeNode root){
        if(root==null)
        return 0;
        
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right)+helper(root);
}
  

int helper(TreeNode root){
    if(root==null){
        return 0;
        }
    if(root.left!=null && root.left.left==null && root.left.right==null){
        return root.left.val;
    }
    return 0;
}
}