// Last updated: 15/09/2026, 16:13:23
1class Solution {
2public:
3    int lastRemaining(int n, bool left = true, int dis = 1) {
4        // observations: in each iteration the input size is cut by half
5        // suppose we did not have this alternate deletion direction
6        // the example would be like 
7        // 1 2 3 4 5 6
8        // 2 4 6        [1 2 3]
9        // 4            [1]
10        // here the input size gets cut by 2, and in each iteration the begin gets multiplied by 2, therefore to get the original position of the reduced set is just to multiple by 2 the number of times reduced
11
12        // one observation we can make is that gap between the elements in first iteration is 1, in second is 2 and in third 4 and so on, increased by 2, since we cut down our size by 2, distance grows by 2
13
14        // final position can be expressed as 2 * recursion( n / 2)
15
16        // but with this direction change, this recursion wont be working straightforward, but the things that dont change is that the gap between elements dont reduce no matter where we start the elimination
17
18        // The head advances by 'gap' whenever it gets eliminated, which happens:
19        //   1. Always when eliminating from left to right.
20        //   2. When eliminating from right to left and the remaining count is odd, which makes the first element to be deleted.
21
22        // in simple words, gap increases each time we reduce, head is updated with the correct gap when its deleted
23
24        if (n == 1)
25            return 1; // just 1 element so return that
26        
27        if (left || n % 2 == 1) // head will be moving in this condition
28            return dis + lastRemaining(n / 2, !left, dis * 2);
29        
30        return lastRemaining(n / 2, !left, dis * 2);
31    }
32};