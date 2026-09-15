// Last updated: 15/09/2026, 16:09:10
1class Solution {
2public:
3    int lengthLongestPath(string input) {
4        istringstream ss(input);
5        string token;
6        size_t max_len = 0;
7        unordered_map<int, int> path_len;
8        path_len[0] = 0;
9        while (getline(ss, token)) {
10            auto pos = token.find_last_of("\t");
11            string name = (pos != std::string::npos) ? token.substr(pos + 1) : token;
12            
13            int depth = token.size() - name.size();
14            if (token.find(".") != std::string::npos) {
15                max_len = max(max_len, path_len[depth] + name.size());
16            } else {
17                path_len[depth + 1] = path_len[depth] + name.size() + 1;
18            }
19        }
20        return max_len;
21    }
22};