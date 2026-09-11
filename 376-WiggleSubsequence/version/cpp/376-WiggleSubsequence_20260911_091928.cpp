// Last updated: 11/09/2026, 09:19:28
1class Solution {
2public:
3    int wiggleMaxLength(vector<int>& nums) {
4        int size=nums.size(), peak=1, valley=1;
5        for(int i=1; i<size; ++i){
6                 if(nums[i]>nums[i-1]) peak = valley + 1;
7            else if(nums[i]<nums[i-1]) valley = peak + 1;
8        }
9        return max(peak , valley );
10    }
11};