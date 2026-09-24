// Last updated: 24/09/2026, 09:59:43
1class Solution {
2public:
3    int maxRotateFunction(vector<int>& A) {
4        long sum = 0, fn = 0;
5        int len = A.size();
6        for(int i=0;i<len;i++) {
7            sum += A[i];
8            fn += (i * A[i]);
9        }
10
11        long l = 1, r;
12        long newfn = fn;
13        
14        while(l < len) {
15            r = l + len - 1;
16            
17            long removed = (l-1) * A[l-1];
18            long added = r * A[r%len];
19            
20            newfn = newfn - removed + added - sum;
21            
22            fn = max(fn, newfn);
23            
24            l++;
25        }
26        
27        return (int)fn;
28    }
29};