// Last updated: 08/09/2026, 10:14:18
1class Solution {
2public:
3    void merge(vector<int> &count, vector<pair<int, int> > &v, int left, int mid, int right) {
4        vector<pair<int, int> > tmp(right-left+1);
5        int i = left;
6        int j = mid+1;
7        int k = 0;
8
9        while (i <= mid && j <= right) {
10            // mind that we're sorting in descending order
11            if (v[i].first <= v[j].first) { 
12                tmp[k++] = v[j++];
13            }
14            else {
15                // only line responsible to update count, related to problem constraint, 
16                // remaining part is just regular mergeSort 
17                count[v[i].second] += right - j + 1;
18                tmp[k++] = v[i++];
19            }
20        }
21        while (i <= mid) {
22            tmp[k++] = v[i++];
23        }
24        while (j <= right) {
25            tmp[k++] = v[j++];
26        }
27        for (int i = left; i <= right; i++)
28            v[i] = tmp[i-left];
29    }        
30
31    void mergeSort(vector<int> &count, vector<pair<int, int> > &v, int left, int right) {
32        if (left >= right) 
33            return;
34
35        int mid = left + (right-left)/2;
36        mergeSort(count, v, left, mid);
37        mergeSort(count, v, mid+1, right);
38        merge(count, v, left, mid, right);
39    }
40
41    vector<int> countSmaller(vector<int>& nums) {
42        int N = nums.size();
43
44        vector<pair<int, int> > v(N);
45        for (int i = 0; i < N; i++)   
46            v[i] = make_pair(nums[i], i);
47
48        vector<int> count(N, 0);
49        // sorting in descending order
50        mergeSort(count, v, 0, N-1);
51
52        return count;
53    }
54};