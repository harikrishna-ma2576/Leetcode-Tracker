// Last updated: 01/09/2026, 09:48:06
1class Solution {
2public:
3    int minDepth(TreeNode *root) {
4        if(!root) return 0;
5        if(!root->left) return 1 + minDepth(root->right);
6        if(!root->right) return 1 + minDepth(root->left);
7        return 1+min(minDepth(root->left),minDepth(root->right));
8    }
9};