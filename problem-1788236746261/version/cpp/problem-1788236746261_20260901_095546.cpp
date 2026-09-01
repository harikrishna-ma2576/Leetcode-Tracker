// Last updated: 01/09/2026, 09:55:46
1/*
2// Definition for a Node.
3class Node {
4public:
5    int val;
6    Node* left;
7    Node* right;
8    Node* next;
9
10    Node() : val(0), left(NULL), right(NULL), next(NULL) {}
11
12    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}
13
14    Node(int _val, Node* _left, Node* _right, Node* _next)
15        : val(_val), left(_left), right(_right), next(_next) {}
16};
17*/
18
19class Solution {
20public:
21    Node* connect(Node* root) 
22    {
23        if (!root)
24            return root;
25        queue<Node*> q;
26        q.push(root);
27        q.push(NULL);
28        while (q.size() > 1)
29        {
30            Node* curr = q.front();
31            q.pop();
32            if (!curr)
33            {
34                q.push(NULL);
35                continue;
36            }
37            curr->next = q.front();
38            if (curr->left)
39                q.push(curr->left);
40            if (curr->right)
41                q.push(curr->right);
42        }
43        return root;
44    }
45};