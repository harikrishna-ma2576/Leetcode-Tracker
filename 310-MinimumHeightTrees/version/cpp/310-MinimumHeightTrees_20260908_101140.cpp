// Last updated: 08/09/2026, 10:11:40
1class Solution {
2public:
3    int dfs(vector<int>&nums,int l,int r,int n,vector<vector<int>>&dp){
4        if(l>r) return 0;
5        if(dp[l][r]!=-1) return dp[l][r];
6
7        int sum=0;
8        for(int i=l;i<=r;i++){
9           int coins=nums[l-1]*nums[i]*nums[r+1];
10           coins+=dfs(nums,l,i-1,n,dp);
11           coins+=dfs(nums,i+1,r,n,dp);
12           sum=max(sum,coins);
13           dp[l][r]=sum;
14        }
15        return dp[l][r];
16    }
17    int maxCoins(vector<int>& nums) {
18        nums.insert(nums.begin(), 1);
19        nums.push_back(1);
20
21        int n = nums.size();
22        vector<vector<int>>dp(n+1,vector<int>(n+1,-1));
23
24        return dfs(nums,1,n-2,n,dp);
25    }
26};