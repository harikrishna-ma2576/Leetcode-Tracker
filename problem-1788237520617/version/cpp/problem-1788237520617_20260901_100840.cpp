// Last updated: 01/09/2026, 10:08:40
1// BFS gives TLE if we store path while traversing because whenever we find a better visit time for a word, we have to clear/make a new path vector everytime. 
2// The idea is to first use BFS to search from beginWord to endWord and generate the word-to-children mapping at the same time. 
3// Then, use DFS (backtracking) to generate the transformation sequences according to the mapping. 
4// The reverse DFS allows us to only make the shortest paths, never having to clear a whole sequence when we encounter better result in BFS
5// No string operations are done, by dealing with indices instead.
6
7
8
9class Solution {
10public:
11bool able(string s,string t){
12    int c=0;
13    for(int i=0;i<s.length();i++)
14        c+=(s[i]!=t[i]);
15    return c==1;
16}
17void bfs(vector<vector<int>> &g,vector<int> parent[],int n,int start,int end){
18    vector <int> dist(n,1005);
19    queue <int> q;
20    q.push(start);
21    parent[start]={-1};
22    dist[start]=0;
23    while(!q.empty()){
24        int x=q.front();
25        q.pop();
26        for(int u:g[x]){
27            if(dist[u]>dist[x]+1){
28                dist[u]=dist[x]+1;
29                q.push(u);
30                parent[u].clear();
31                parent[u].push_back(x);
32            }
33            else if(dist[u]==dist[x]+1)
34                parent[u].push_back(x);
35        }
36    }
37}
38void shortestPaths(vector<vector<int>> &Paths, vector<int> &path, vector<int> parent[],int node){
39    if(node==-1){
40        // as parent of start was -1, we've completed the backtrack
41        Paths.push_back(path);
42        return ;
43    }
44    for(auto u:parent[node]){
45        path.push_back(u);
46        shortestPaths(Paths,path,parent,u);
47        path.pop_back();
48    }
49}
50vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
51    // start and end are indices of beginWord and endWord
52    int n=wordList.size(),start=-1,end=-1;
53    vector<vector<string>> ANS;
54    for(int i=0;i<n;i++){
55        if(wordList[i]==beginWord)
56            start=i;
57        if(wordList[i]==endWord)
58            end=i;
59    }
60    
61    // if endWord doesn't exist, return empty list
62    if(end==-1)
63        return ANS;
64    
65    // if beginWord doesn't exist, add it in start of WordList
66    if(start==-1){
67        wordList.emplace(wordList.begin(),beginWord);
68        start=0;
69        end++;
70        n++;
71    }
72    // for each word, we're making adjency list of neighbour words (words that can be made with one letter change)
73    // Paths will store all the shortest paths (formed later by backtracking)
74    vector<vector<int>> g(n,vector<int>()),Paths;
75    
76    // storing possible parents for each word (to backtrack later), path is the current sequence (while backtracking)
77    vector<int> parent[n],path;
78    
79    // creating adjency list for each pair of words in the wordList (including beginword)
80    for(int i=0;i<n-1;i++)
81        for(int j=i+1;j<n;j++)
82            if(able(wordList[i],wordList[j])){
83                g[i].push_back(j);
84                g[j].push_back(i);
85            }
86    
87    bfs(g,parent,n,start,end); 
88    
89    // backtracking to make shortestpaths
90    shortestPaths(Paths,path,parent,end);
91    for(auto u:Paths){
92        vector <string> now;
93        for(int i=0;i<u.size()-1;i++)
94            now.push_back(wordList[u[i]]);
95        reverse(now.begin(),now.end());
96        now.push_back(wordList[end]);
97        ANS.push_back(now);
98    }
99    return ANS;
100}
101}; 