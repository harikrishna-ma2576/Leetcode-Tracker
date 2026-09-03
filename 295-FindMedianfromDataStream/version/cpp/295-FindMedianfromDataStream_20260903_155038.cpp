// Last updated: 03/09/2026, 15:50:38
1class MedianFinder {
2public:
3    priority_queue<int> maxH;
4    priority_queue<int, vector<int>, greater<int>> minH;
5
6    MedianFinder() {
7    }
8
9    void addNum(int num) {
10        minH.push(num);
11
12        maxH.push(minH.top());
13        minH.pop();
14
15        if (maxH.size() - minH.size() > 1) {
16            minH.push(maxH.top());
17            maxH.pop();
18        }
19    }
20
21    double findMedian() {
22        if (minH.size() == maxH.size()) {
23            return (minH.top() + maxH.top()) / 2.0;
24        }
25        return maxH.top() / 1.0;
26    }
27};