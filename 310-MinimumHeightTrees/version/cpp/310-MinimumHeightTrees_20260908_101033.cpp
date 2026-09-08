// Last updated: 08/09/2026, 10:10:33
1//Comment and Upvote
2
3class Solution {
4public:
5    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
6        //base case i.e only one node is available
7        if(n==1) return vector<int>{0};
8        
9        //Now we need to find the list of nodes for adjacency
10        vector<vector<int>>graph(n);
11        
12        //Now count the degree of nodes
13        vector<int>degree(n,0);
14        
15        //populate graph adjacency list and degree count of nodes
16        for(int i=0;i<edges.size();i++){
17            int a=edges[i][0], b=edges[i][1];
18            
19            graph[a].push_back(b);
20            graph[b].push_back(a);
21            degree[a]++;
22            degree[b]++;
23        }
24        queue<int>queue_degree_1;
25        
26        //push all the nodes with degree 1
27        for(int i=0;i<n;i++) if(degree[i]==1) queue_degree_1.push(i);
28        
29        //MHT root nodes
30        vector<int>res;
31        
32        //Run BFS until queue is empty
33        while(!queue_degree_1.empty()){
34            int n = queue_degree_1.size();
35            res.clear();//clear the root nodes
36            
37            //This is our level order traverse
38            while(n--){
39                int node = queue_degree_1.front();
40                queue_degree_1.pop();
41                
42                //add current node into the root node vector
43                res.push_back(node);
44                
45                //Now it's time for neighbouring nodes
46                for(int i=0;i<graph[node].size();i++){
47                    //decrease degree of neighbour nodes and push leaff nodes intp queue
48                    degree[graph[node][i]]--;
49                    if(degree[graph[node][i]]==1) queue_degree_1.push(graph[node][i]);
50                }
51            }
52        }
53        
54        return res;//root nodes of MHT
55    }
56};