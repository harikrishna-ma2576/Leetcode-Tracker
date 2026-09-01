// Last updated: 01/09/2026, 12:36:04
1class MinStack {
2    Stack<Integer> stack = new Stack<>();
3    Stack<Integer> minStack = new Stack<>();
4
5    public MinStack() {
6    }
7
8    public void push(int val) {
9        stack.push(val);
10
11        if (minStack.isEmpty() || val <= minStack.peek())
12            minStack.push(val);
13    }
14
15    public void pop() {
16        if (stack.pop().equals(minStack.peek()))
17            minStack.pop();
18    }
19
20    public int top() {
21        return stack.peek();
22    }
23
24    public int getMin() {
25        return minStack.peek();
26    }
27}