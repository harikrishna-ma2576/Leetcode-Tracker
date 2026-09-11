// Last updated: 11/09/2026, 09:11:07
1class Solution {
2public:
3    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
4        priority_queue<pair<int,pair<int,int>>, vector<pair<int,pair<int,int>>>, greater<pair<int,pair<int,int>>>> pq;
5        int n = nums1.size(), m = nums2.size();
6        vector<vector<int>> ans;
7        for(int i = 0; i < n; i++)
8            pq.push({nums1[i]+nums2[0],{i,0}});
9        while(!pq.empty() && k--)
10        {
11            pair<int,pair<int,int>> tp = pq.top();
12            int x = tp.second.first, y = tp.second.second;
13            pq.pop();
14            ans.push_back({nums1[x], nums2[y]});
15            if(y != m-1)
16                pq.push({nums1[x]+nums2[y+1],{x, y+1}});
17        }
18        return ans;
19    }
20};