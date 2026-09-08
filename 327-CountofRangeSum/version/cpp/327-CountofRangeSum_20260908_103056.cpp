// Last updated: 08/09/2026, 10:30:56
1class Solution {
2public:
3    
4    int countWithMergeSort(vector<long> &sums, int left, int right, int lower, int upper)
5    {
6        int count = 0;
7        
8        if(right - left <= 1)
9        {
10            if(right - left == 1)
11            {
12                return (lower <= sums[left] && sums[left] <= upper);
13            }
14            else
15            {
16                return 0;
17            }
18        }
19        
20        int mid = (left + right)/2;
21        
22        int leftSideSum = countWithMergeSort(sums, left, mid, lower, upper);
23        int rightSideSum = countWithMergeSort(sums, mid, right, lower, upper);
24        
25        
26        int i = left;
27        int j = mid;
28        
29        int n = 0;
30        int m = 0;
31        
32        vector<long> cache(right - left, 0);
33        
34        int k = 0;
35        
36        
37        while(i < mid)
38        {
39            
40
41            while(mid+n < right && sums[mid+n] < sums[i]+lower)
42                {
43                    n++;
44                }
45            
46            while(mid+m < right && sums[mid+m] <= sums[i] + upper)
47                {
48                    m++;
49                }
50            
51            while(j < right && sums[j] < sums[i])
52            {
53                cache[k++] = sums[j++];
54            }
55            
56            cache[k++] = sums[i++];
57            
58            count += m-n;
59        }
60        
61        
62        while(j < right)
63        {
64            cache[k++] = sums[j++];
65        }
66        
67        
68        for(int idx = 0; idx<cache.size(); idx++)
69        {
70            sums[left + idx] = cache[idx];
71        }
72    
73        return leftSideSum + rightSideSum + count;
74        
75    }
76    
77    int countRangeSum(vector<int>& nums, int lower, int upper) {
78        
79        vector<long> prefixSum(nums.size(),0);
80        
81        int n = nums.size();
82        
83        prefixSum[0] = nums[0];
84        
85        for(int i = 1; i<nums.size(); i++)
86        {
87            prefixSum[i] = nums[i] + prefixSum[i-1];
88        }
89        
90        return countWithMergeSort(prefixSum, 0, n, lower, upper);
91    }
92};