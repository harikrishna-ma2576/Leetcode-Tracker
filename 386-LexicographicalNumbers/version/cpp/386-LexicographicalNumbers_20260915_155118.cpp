// Last updated: 15/09/2026, 15:51:18
1class Solution {
2public:
3    vector<int> lexicalOrder(int n) {
4        vector<int> res;
5        for(int i=1; i<=n; i++){
6            res.push_back(i);
7        }
8        sort(res.begin(),res.end(),[](const auto & a,const auto & b){
9            string x=to_string(a),y=to_string(b);
10            int i=0,j=0;
11            while(i < x.size() && j<y.size() && x[i] == y[j]){
12                i++;
13                j++;
14            }
15            if(i==x.size()) return true;
16            else if(j==y.size()) return false;
17            return x[i] < y[j];
18        });
19        return res;
20    }
21};