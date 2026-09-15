// Last updated: 15/09/2026, 14:42:35
1class Solution {
2public:
3    vector<int> dp;
4    int help(vector<int> &nums, int T, int n){
5		// base case: if target is 0, we found combination then return 1
6        if(T==0) return 1;
7        int ans=0; 
8		
9		// memoisation
10        if(dp[T]!=-1) return dp[T];
11		
12		// picking up each elements less than target and 
13		// calling this function recursively
14        for(int i=0; i<n; i++){
15            if(nums[i]<=T){
16                ans+=help(nums, T-nums[i], n);
17            }
18        }
19        return dp[T]= ans;
20    }
21    int combinationSum4(vector<int>& nums, int target) {
22        int n=nums.size();
23		// resizing the dp array to store values from 0 to target
24        dp.resize(target+1,-1);
25        return help(nums, target, n);
26    }
27};