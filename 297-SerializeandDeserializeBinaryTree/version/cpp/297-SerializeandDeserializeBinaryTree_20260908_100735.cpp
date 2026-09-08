// Last updated: 08/09/2026, 10:07:35
1class Codec {
2public:
3
4    string serialize(TreeNode* root) {
5        ostringstream out;
6        serialize(root, out);
7        return out.str();
8    }
9
10    TreeNode* deserialize(string data) {
11        istringstream in(data);
12        return deserialize(in);
13    }
14
15private:
16
17    void serialize(TreeNode* root, ostringstream& out) {
18        if (root) {
19            out << root->val << ' ';
20            serialize(root->left, out);
21            serialize(root->right, out);
22        } else {
23            out << "# ";
24        }
25    }
26
27    TreeNode* deserialize(istringstream& in) {
28        string val;
29        in >> val;
30        if (val == "#")
31            return nullptr;
32        TreeNode* root = new TreeNode(stoi(val));
33        root->left = deserialize(in);
34        root->right = deserialize(in);
35        return root;
36    }
37};