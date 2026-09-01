// Last updated: 01/09/2026, 09:42:51
1/**
2 * Definition for a binary tree node.
3 * struct TreeNode {
4 *     int val;
5 *     TreeNode *left;
6 *     TreeNode *right;
7 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
8 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
9 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
10 * };
11 */
12
13class Solution {
14public:
15    vector<vector<int>> levelOrderBottom(TreeNode* root) {
16
17        // If the tree is empty, return an empty answer.
18        if(root == nullptr){
19            return {};
20        }
21
22        vector<vector<int>> ans;
23
24        // Queue is used for BFS (level-order traversal).
25        queue<TreeNode*> q;
26        q.push(root);
27
28        while(!q.empty()){
29
30            // Number of nodes in the current level.
31            int n = q.size();
32
33            vector<int> temp;
34
35            // Process all nodes of the current level.
36            for(int i = 0; i < n; i++){
37
38                TreeNode* help = q.front();
39                q.pop();
40
41                // Store current node's value.
42                temp.push_back(help->val);
43
44                // Add children for the next level.
45                if(help->left){
46                    q.push(help->left);
47                }
48
49                if(help->right){
50                    q.push(help->right);
51                }
52            }
53
54            // Store the current level.
55            ans.push_back(temp);
56        }
57
58        // BFS generated levels from top to bottom,
59        // so reverse them to get bottom-to-top order.
60        reverse(ans.begin(), ans.end());
61
62        return ans;
63    }
64};