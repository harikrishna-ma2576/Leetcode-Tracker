// Last updated: 01/09/2026, 12:35:14
1class Solution {
2    public int findMin(int[] nums) {
3        int left = 0;
4        int right = nums.length - 1;
5
6        while (left < right) {
7            int mid = left + (right - left) / 2;
8
9            if (nums[mid] < nums[right]) {
10                right = mid;
11            } else if (nums[mid] > nums[right]) {
12                left = mid + 1;
13            } else {
14                right--;
15            }
16        }
17
18        return nums[left];
19    }
20}